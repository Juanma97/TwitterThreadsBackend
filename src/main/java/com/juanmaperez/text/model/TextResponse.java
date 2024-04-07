package com.juanmaperez.text.model;

import com.juanmaperez.common.model.response.BasicResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TextResponse extends BasicResponse{
    private final String text;
    
    public TextResponse(final HttpStatus httpStatus, final String error, final String text){
        super(httpStatus, error);
        this.text = text;
    }
}
