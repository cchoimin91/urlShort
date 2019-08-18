package com.choimin.urlshort.controller;


import com.choimin.urlshort.model.UrlShortGetDto;
import com.choimin.urlshort.model.UrlShortSetDto;
import com.choimin.urlshort.service.UrlShortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *  http://localhost:8080/swagger-ui.html
 */
@Api(tags = "Short URL 생성", description = "url을 줄여줍니다..")
@Slf4j
@Controller
public class UrlShortController {

    @Autowired
    private UrlShortService urlShortService;

    @ApiOperation(value ="화면호출" , hidden = true)
    @GetMapping("/")
    public String index() throws Exception{
        return "index";
    }


    @ApiOperation(value = "shortUrl 생성", notes = "0~9,a~z,A~Z로 구성된 8자리이내의 url을 생성합니다 ")
    @ResponseBody
    @PostMapping(value = "/createUrlShort", produces = MediaType.APPLICATION_JSON_VALUE)
    public UrlShortGetDto createUrlShort(@RequestBody UrlShortSetDto urlShortSetDto) {
        log.info("입력 Url : {}", urlShortSetDto.toString());

        UrlShortGetDto shortUrl = urlShortService.createShortUrl(urlShortSetDto);

        log.info("결과 Url : {}", shortUrl.getShortUrl());

        return shortUrl;
    }


    @ApiOperation(value = "입력받은 shorUrl을 리다이랙트 합니다", hidden = true)
    @GetMapping(value = "/{shortUrl}")
    public String redirect(@PathVariable("shortUrl") String shortUrl){
        log.info("입력 Url : {}", shortUrl );

        String redirectUrl = urlShortService.findByOriginUrl(shortUrl);

        log.info("리다이랙트 url : {}", shortUrl);

        return "redirect:" + redirectUrl;
    }

}
