package com.juanmaperez.text.controller;

import com.juanmaperez.text.service.ExtractTextService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ExtractTextControllerTest{
    
    private final String URL = "https://www.urltest.com";
    private final ExtractTextService extractTextService = mock(ExtractTextService.class);
    private final ExtractTextController sut = new ExtractTextController(extractTextService);
    
    @Test
    void shouldCallServiceToExtractText(){
        sut.extractText(URL); 
        
        verify(extractTextService).extractText(URL);
    }
}
