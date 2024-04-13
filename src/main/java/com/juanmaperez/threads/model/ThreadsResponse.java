package com.juanmaperez.threads.model;

import com.juanmaperez.common.model.response.BasicResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ThreadsResponse extends BasicResponse{
    private List<String> thread;
    
    public ThreadsResponse(final HttpStatus httpStatus, final String error, final List<String> thread){
        super(httpStatus, error);
        this.thread = thread;
    }
}
