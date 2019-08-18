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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "짧은URL생성", description = "url을 줄여줍니다..")
@Slf4j
@Controller
public class UrlShortController {
    //http://localhost:8080/swagger-ui.html

    @Autowired
    private UrlShortService urlShortService;

    @GetMapping("/")
    public String index() {
        System.out.println("테스트");
        return "index";
    }

    @ApiOperation(value = "shortUrl 생성", notes = "0~9,a~z,A~Z로 구성된 8자리이내의 url을 생성합니다 ")
    @ResponseBody
    @PostMapping(value = "/createUrlShort", produces = MediaType.APPLICATION_JSON_VALUE)
    public UrlShortGetDto createUrlShort(@RequestBody UrlShortSetDto urlShortSetDto) {
        log.info("입력 Url: {}", urlShortSetDto.toString());

        UrlShortGetDto shortUrl = urlShortService.createShortUrl(urlShortSetDto);

        log.info("결과 Url : {}", shortUrl.getShortUrl());

        return shortUrl;
    }

}
