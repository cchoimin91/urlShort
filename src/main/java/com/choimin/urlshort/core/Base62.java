package com.choimin.urlshort.core;

public class Base62 {

    private static final String BASE62_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    /**
     * DB키값을 62진수로 인코딩 합니다.
     * @param dbKey DB키값
     * @return 62진수로 인코딩된 문자열
     */
    public static String encode(long dbKey) {
        if (dbKey < 0) {
            throw new IllegalArgumentException("dbkey는 0보다 커야 합니다.");
        }

        String encodeValue = "";

        while (dbKey > 0) {
            encodeValue = BASE62_CHARACTERS.charAt((int) (dbKey % 62)) + encodeValue;
            dbKey /= 62;
        }

        return encodeValue;
    }


    /**
     * 인코딩된 문자열을 디코딩 합니다
     * @param base62Encode base62로 인코딩된 문자열
     * @return DBKey값
     */
    public static long decode(String base62Encode) {
        for (char character : base62Encode.toCharArray()) {
            if (!BASE62_CHARACTERS.contains(String.valueOf(character))) {
                throw new IllegalArgumentException("BASE62_CHARACTERS가 아닙니다 input: " + character);
            }
        }

        long dbKey = 0;

        base62Encode = new StringBuffer(base62Encode).reverse().toString();

        long count = 1;

        for (char character : base62Encode.toCharArray()) {
            dbKey += BASE62_CHARACTERS.indexOf(character) * count;
            count *= 62;
        }

        return dbKey;
    }

}
