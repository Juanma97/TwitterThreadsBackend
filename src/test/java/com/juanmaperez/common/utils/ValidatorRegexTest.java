package com.juanmaperez.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorRegexTest{

    private final String URL_REGEX = "^(https?|ftp)://[a-zA-Z0-9.-]+(\\\\.[a-zA-Z]{1,})(:[0-9]+)?(/\\\\S*)?$\";\n";

    private final ValidatorRegex sut = new ValidatorRegex();

    @Test
    void givenAValidUrlShouldReturnTrue(){
        assertTrue(sut.validate(URL_REGEX, "https://www.google.com"));
        assertTrue(sut.validate(URL_REGEX, "http://google.com"));
        assertTrue(sut.validate(URL_REGEX, "http://www.google.es"));
        assertTrue(sut.validate(URL_REGEX, "http://www.google.com"));
        assertTrue(sut.validate(URL_REGEX, "http://www.google.com.co"));
        assertTrue(sut.validate(URL_REGEX, "http://www.google.net"));
        assertTrue(sut.validate(URL_REGEX, "http://www.google.uk"));
    }

    @Test
    void givenANotValidUrlShouldReturnFalse(){
        assertFalse(sut.validate(URL_REGEX, "https://www.google"));
        assertFalse(sut.validate(URL_REGEX, "htt://google.com"));
        assertFalse(sut.validate(URL_REGEX, "httpss://www.google.es"));
        assertFalse(sut.validate(URL_REGEX, "http//www.google.com"));
        assertFalse(sut.validate(URL_REGEX, "http:/www.google.com.co"));
        assertFalse(sut.validate(URL_REGEX, "http://www..net"));
        assertFalse(sut.validate(URL_REGEX, "http://www.google/"));
    }

}