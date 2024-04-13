package com.juanmaperez.common.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Pattern;

@Component
public class ValidatorRegex{
    
    public boolean validate(final String regex, final Object ...args){
        final var pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return Arrays.stream(args).allMatch(o -> pattern.matcher((String) o).find());
    }
}
