package com.juanmaperez.common.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicResponse{
    private final String httpStatus;
    private final String error;
    
    public BasicResponse(final String httpStatus, final String error){
        this.httpStatus = httpStatus;
        this.error = error;
    }
}
