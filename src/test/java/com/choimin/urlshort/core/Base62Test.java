package com.choimin.urlshort.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Base62Test {


    /**
     *  DB 시퀀스값으로 인코딩한 값들이 중복되는 것이 있는지 검증
     *  - 1억개 테스트시 OOM발생 (시간 매우 오래걸림)
     *  - 5천만개 테스트시 OOM발생 (시간 매우 오래걸림)
     *  - 천만개 통과
     */
    @Test
    public void 인코딩한값중_중복되는키가있는가(){
        //given
        String result = null; //중복된 결과값 담을 변수
        String endcodeValue; //인코딩한 값
        long maxKey = 10000; // db최대 키값
        Set<String> set  = new HashSet<>(); // 중복체크를 위해 생성

        //when
        for(long i=1; i<=maxKey; i++){
            endcodeValue = Base62.encode(i);

            if(set.contains(endcodeValue)){
                log.info("중복키되는 키:{}", endcodeValue);
                result = endcodeValue;
                break;
            }

            set.add(endcodeValue);
        }

        //then
        assertEquals(null, result);
    }



    @Test
    public void 인코딩_디코딩_값비교_단건(){
        //given
        long dbKey = 62;
        String encode;
        long decode;

        //when
        log.info("dbKey:{}", dbKey);

        encode = Base62.encode(dbKey);
        log.info("인코딩:{}", encode);

        decode = Base62.decode(encode);
        log.info("디코딩:{}", decode);

        //then
        assertEquals(dbKey, decode);
    }



    @Test
    public void 인코딩_디코딩_여러건비교(){
        //given
        boolean result = true;
        long maxDbKey = 10000000;

        //when
        for(long i=1 ; i<=maxDbKey ;i++){
            String encodeValue = Base62.encode(i);
            long decodeValue = Base62.decode(encodeValue);

            if(i != decodeValue){
                log.info("디코딩 결과 값이 맞지 않음 dbKey:{} decodeValue:{}", i, decodeValue);
                result = false;
                break;
            }
        }

        //then
        assertEquals(true, result);
    }



    @Test
    public void 인코딩문자열길이확인(){
        //given
        boolean res = true;
        long keyCount = 1000000000; //키

        //when
        for(long i=1 ; i<=keyCount; i++){
            String e = Base62.encode(i);
            if(e.length()==8){
               log.info("8자리가 되는 key : {}", i);
                res = false;
                break;
            }
        }
        //then
        assertTrue(res);
    }
} // CLASS END
