package com.juanmaperez.common.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BasicResponse{
    private final HttpStatus httpStatus;
    private final String error;
    
    public BasicResponse(final HttpStatus httpStatus, final String error){
        this.httpStatus = httpStatus;
        this.error = error;
    }
}
