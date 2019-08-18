package com.choimin.urlshort.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "shortening한 결과 dto")
public class UrlShorGetDto {

    @ApiModelProperty(notes = "입력받은 Url")
    private String orginUrl;

    @ApiModelProperty(notes = "shortening Url")
    private String shortUrl;

}
