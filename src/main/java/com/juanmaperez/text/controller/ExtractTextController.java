package com.juanmaperez.text.controller;

import com.juanmaperez.text.model.TextResponse;
import com.juanmaperez.text.service.ExtractTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("extract-text")
public class ExtractTextController{
    
    private final ExtractTextService extractTextService;
    
    @Autowired
    public ExtractTextController(final ExtractTextService extractTextService){
        this.extractTextService = extractTextService;
    }
    
    @GetMapping (produces = "application/json")
    public TextResponse extractText(@RequestParam("url") final String url){
        return extractTextService.extractText(url);
    }
}
