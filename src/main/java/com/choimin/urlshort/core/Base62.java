package com.choimin.urlshort.core;

public class Base62 {

    private static final String BASE62_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    /**
     *
     * @param dbKey DB키값을 입력합니다.
     * @return 62진수로 인코딩된 문자열을 반환합니다.
     */
    public static String encode(long dbKey) {
        if (dbKey < 0) {
            throw new IllegalArgumentException("dbkey는 0보다 커야 합니다.");
        }

        StringBuffer sb = new StringBuffer();

        while (dbKey > 0) {
            sb.append(BASE62_CHARACTERS.charAt((int) (dbKey % 62))).append(sb);
            dbKey = dbKey / 62;
        }

        return sb.toString();
    }

}
