package com.choimin.urlshort.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "입력 url dto")
@Setter
@Getter
@ToString
public class UrlShortSetDto {

    @ApiModelProperty(notes = "db키값", hidden = true)
    private long seq;

    @ApiModelProperty(notes = "입력 할 Url", example = "http://kakaopay.com")
    private String originUrl;

    @ApiModelProperty(notes = "short Url", hidden = true)
    private String shortUrl;
}
