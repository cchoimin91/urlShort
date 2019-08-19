package com.choimin.urlshort.service;

import com.choimin.urlshort.exception.EmptyUrlException;
import com.choimin.urlshort.mapper.UrlShortMapper;
import com.choimin.urlshort.model.UrlShortGetDto;
import com.choimin.urlshort.model.UrlShortSetDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortServiceTest {

    @Autowired
    private UrlShortService urlShortService;

    @Test
    public void 단축URL생성_Null체크 (){
        //given
        UrlShortSetDto param = new UrlShortSetDto();
        param.setOriginUrl("http://test.com");

        //when
        UrlShortGetDto urlShortGetDto = urlShortService.createShortUrl(param);
        log.info("생성된 단축 url : {}", urlShortGetDto.getShortUrl());

        //then
        assertThat(urlShortGetDto.getShortUrl(), is(notNullValue()));
    }


    @Test(expected = EmptyUrlException.class)
    public void url유효성체크(){
        //given
        UrlShortSetDto param = new UrlShortSetDto();
        param.setOriginUrl(null);

        //then
        urlShortService.validationCheck(param);
    }

}
