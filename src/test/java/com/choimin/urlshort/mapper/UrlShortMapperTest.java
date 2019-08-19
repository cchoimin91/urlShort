package com.choimin.urlshort.mapper;

import com.choimin.urlshort.model.UrlShortSetDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortMapperTest {

    @Autowired
    private UrlShortMapper urlShortMapper;


    /**
     *  return 받은 dbKey값이 0보다 커야한다
     */
    @Test
    public void insertOriginUrl_test(){
        //given
        boolean result = false;

        //when
        UrlShortSetDto param = new UrlShortSetDto();
        param.setOriginUrl("http://abcdefg.com");

        long dbKey = urlShortMapper.insertOriginUrl(param);

        if(dbKey>0){
            result = true;
        }

        //then
        assertEquals(true, result);
    }



    /**
     * where 검색시 대소문자를 구분하는지를 위한 테스트
     * return 받은 값이 오직 1 or 0 이여야 한다.
     */
    @Test
    public void existUrl_test(){
        //given
        boolean result = true;

        //then
        Integer row = urlShortMapper.existUrl("http://abcdefg.com");
        log.info("row : {}" , row);

        if(row>1 || row<0){
            result = false;
        }

        //then
        assertEquals(result, true);
    }

}
