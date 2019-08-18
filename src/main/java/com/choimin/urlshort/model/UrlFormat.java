package com.choimin.urlshort.model;

public class UrlFormat {

    public static final String DOMAIN = "http://localhost:";

    public static final String PORT = "8080";

    public static  final String SLASH = "/";

    public static final String HTTP = "http://";

    public static final String HTTPS = "https://";

    public static String makeUrl(String shortUrl){
        StringBuffer sb = new StringBuffer();
        return sb.append(DOMAIN)
                .append(PORT)
                .append(SLASH)
                .append(shortUrl)
                .toString();
    }

}
