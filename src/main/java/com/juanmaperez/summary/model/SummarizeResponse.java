package com.juanmaperez.summary.model;

import com.juanmaperez.common.model.response.BasicResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SummarizeResponse extends BasicResponse{
    private final String summary;
    
    public SummarizeResponse(final HttpStatus httpStatus, final String error, final String summary){
        super(httpStatus, error);
        this.summary = summary;
    }
}
