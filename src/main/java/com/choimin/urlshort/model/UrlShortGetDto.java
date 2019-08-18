package com.choimin.urlshort.model;

        import io.swagger.annotations.ApiModel;
        import io.swagger.annotations.ApiModelProperty;
        import lombok.Getter;
        import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "shortening한 결과 dto")
public class UrlShortGetDto {

    @ApiModelProperty(notes = "입력받은 Url")
    private String originUrl;

    @ApiModelProperty(notes = "shortening한 Url")
    private String shortUrl;
}
