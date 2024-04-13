package com.juanmaperez.summary.controller;

import com.juanmaperez.summary.model.SummarizeResponse;
import com.juanmaperez.summary.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("summary")
public class SummaryController{
    
    private final SummaryService summaryService;
    
    @Autowired
    public SummaryController(final SummaryService summaryService){
        this.summaryService = summaryService;
    }

    @GetMapping(produces = "application/json")
    public SummarizeResponse summarize(final String text){
        return summaryService.summarize(text);
    }
}
