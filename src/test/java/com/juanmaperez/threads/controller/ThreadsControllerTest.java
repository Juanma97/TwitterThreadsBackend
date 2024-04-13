package com.juanmaperez.threads.controller;

import com.juanmaperez.threads.model.ThreadsResponse;
import com.juanmaperez.threads.service.ThreadsService;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ThreadsControllerTest{
    private final String text = "----text ----text2\n----text3";
    private final ThreadsService threadsService = mock(ThreadsService.class);
    private final ThreadsController sut = new ThreadsController(threadsService);
    
    @Test
    void givenATextShouldReturnThisTextInTwitterThreadFormat(){
        final ThreadsResponse response = sut.convertToThread(text);
        
        assertThat(response.getThread().length, is(3));
        verify(threadsService).convertToThread(text);
    }

}