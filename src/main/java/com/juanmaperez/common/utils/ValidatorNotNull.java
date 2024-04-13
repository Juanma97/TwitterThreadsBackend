package com.juanmaperez.common.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class ValidatorNotNull{
    
    public boolean validate(final Object ...args){
        return Arrays.stream(args).allMatch(Objects::nonNull);
    }
}
