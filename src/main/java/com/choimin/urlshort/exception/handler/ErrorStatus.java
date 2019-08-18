package com.choimin.urlshort.exception.handler;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "에러상태 객체")
public class ErrorStatus {

    @ApiModelProperty(notes = "에러코드")
    private String code;

    @ApiModelProperty(notes = "에러설명")
    private String description;

    @ApiModelProperty(notes = "에러세부 설명")
    private String detail;

}
