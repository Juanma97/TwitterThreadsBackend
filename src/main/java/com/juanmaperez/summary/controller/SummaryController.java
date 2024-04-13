package com.juanmaperez.summary.controller;

import com.juanmaperez.summary.model.SummarizeResponse;
import com.juanmaperez.summary.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(produces = "application/json")
    public SummarizeResponse summarize(@RequestBody final String text){
        return summaryService.summarize(text);
    }
}
