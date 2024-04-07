package com.juanmaperez.text.controller;

import com.juanmaperez.text.model.TextResponse;
import com.juanmaperez.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TextController{
    
    private final TextService textService;
    
    @Autowired
    public TextController(final TextService textService){
        this.textService = textService;
    }
    
    public TextResponse extractText(final String url){
        return textService.extractText(url);
    }
}
