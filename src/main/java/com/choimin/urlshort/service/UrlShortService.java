package com.choimin.urlshort.service;


import com.choimin.urlshort.core.Base62;
import com.choimin.urlshort.exception.EmptyUrlException;
import com.choimin.urlshort.exception.UrlFormatException;
import com.choimin.urlshort.mapper.UrlShortMapper;
import com.choimin.urlshort.model.UrlFormat;
import com.choimin.urlshort.model.UrlShortGetDto;
import com.choimin.urlshort.model.UrlShortSetDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UrlShortService {

    @Autowired
    private UrlShortMapper urlShortMapper;



    /**
     * short url을 만듭니다
     * @param shortSetDto
     * @return
     */
    @Transactional
    public UrlShortGetDto createShortUrl(UrlShortSetDto shortSetDto){
        validationCheck(shortSetDto);

        //입력받은 url이 DB에 있다면 DB에 있는 short url을 반환한다.
        if(existUrl(shortSetDto.getOriginUrl())){
            log.info("이미존재하는 URL 입니다. 입력 url : {}", shortSetDto.getOriginUrl());
            UrlShortGetDto result = urlShortMapper.getOriginUrl(shortSetDto.getOriginUrl());
            result.setShortUrl(UrlFormat.makeUrl(result.getShortUrl()));
            return result;
        }

        urlShortMapper.insertOriginUrl(shortSetDto);
        long dbKey = shortSetDto.getSeq();
        log.info("DB return Key : {}", dbKey);

        String enCodeUrl = Base62.encode(dbKey);

        UrlShortSetDto param = new UrlShortSetDto();
        param.setSeq(dbKey);
        param.setShortUrl(enCodeUrl);

        urlShortMapper.updateShortUrl(param);

        UrlShortGetDto result = new UrlShortGetDto();
        result.setOriginUrl(shortSetDto.getOriginUrl());
        result.setShortUrl(UrlFormat.makeUrl(enCodeUrl));

        return result;
    }



    /**
     *  입력받은 URL이 DB안에 있는지 조회해서 존재한다면 TRUE를 반환합니다.
     * @param originUrl
     * @return
     */
    public Boolean existUrl(String originUrl){
        Integer count = urlShortMapper.existUrl(originUrl);
        return count>0?true:false;
    }



    /**
     * 입력받은 URL에 대해서 유효성 검사를 합니다.
     * @param urlShortSetDto
     */
    public void validationCheck(UrlShortSetDto urlShortSetDto){
        String inputUrl = urlShortSetDto.getOriginUrl();

        if(StringUtils.isBlank(inputUrl)){
            log.warn("URL VALIDATION - [URL EMPTY ERROR] PARAM : {} ", inputUrl);
            throw new EmptyUrlException("입력한 Url이 비어있거나 공백입니다.");
        }

        if(! inputUrl.startsWith(UrlFormat.HTTP) && ! inputUrl.startsWith(UrlFormat.HTTPS)){
            log.warn("URL VALIDATION - [URL FORMAT ERROR] PARAM : {} ", inputUrl);
            throw new UrlFormatException("Url 형식은 [http://], [https://]로 시작해야 합니다");
        }
    }

}
