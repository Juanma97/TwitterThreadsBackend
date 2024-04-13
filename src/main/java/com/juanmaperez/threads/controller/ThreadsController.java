package com.juanmaperez.threads.controller;

import com.juanmaperez.threads.model.ThreadsResponse;
import com.juanmaperez.threads.service.ThreadsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("threads")
public class ThreadsController{
    private final ThreadsService threadsService;
    
    public ThreadsController(final ThreadsService threadsService){
        this.threadsService = threadsService;
    }
    
    @PostMapping
    public ThreadsResponse convertToThread(@RequestBody final String text){
        return threadsService.convertToThread(text);
    }
}
