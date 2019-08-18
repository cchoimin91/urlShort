package com.choimin.urlshort.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("shorturl")
public class UrlShortDomain {

    private String domain;

}
