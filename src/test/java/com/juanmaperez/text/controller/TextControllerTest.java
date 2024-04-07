package com.juanmaperez.text.controller;

import com.juanmaperez.text.service.TextService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TextControllerTest{
    
    private final String URL = "https://www.urltest.com";
    private final TextService textService = mock(TextService.class);
    private final TextController sut = new TextController(textService);
    
    @Test
    void shouldCallServiceToExtractText(){
        sut.extractText(URL); 
        
        verify(textService).extractText(URL);
    }
}
