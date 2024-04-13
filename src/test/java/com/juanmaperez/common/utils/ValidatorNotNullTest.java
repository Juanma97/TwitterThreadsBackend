package com.juanmaperez.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorNotNullTest{

    final ValidatorNotNull sut = new ValidatorNotNull();

    @Test
    void givenNullObjectShouldReturnFalse(){
        final Object nullObject = null;
        assertFalse(sut.validate(nullObject));
    }

    @Test
    void givenNonNullObjectShouldReturnTrue(){
        final Object nonNullObject = new Object();
        assertTrue(sut.validate(nonNullObject));
    }

    @Test
    void givenMultipleObjectShouldReturnTrueWhenAllAreNonNull(){
        final Object nonNullObject1 = new Object();
        final Object nonNullObject2 = new Object();
        final Object nonNullObject3 = new Object();
        assertTrue(sut.validate(nonNullObject1, nonNullObject2, nonNullObject3));
    }

    @Test
    void givenMultipleObjectShouldReturnFalseWhenAllAreNull(){
        final Object nullObject1 = null;
        final Object nullObject2 = null;
        assertFalse(sut.validate(nullObject1, nullObject2));
    }

    @Test
    void givenMultipleObjectShouldReturnFalseWhenOnlyOneIsNull(){
        final Object nonNullObject = new Object();
        final Object nullObject = null;
        assertFalse(sut.validate(nonNullObject, nullObject));
    }

}