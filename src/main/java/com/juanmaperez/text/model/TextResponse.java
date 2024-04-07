package com.juanmaperez.text.model;

import com.juanmaperez.common.model.response.BasicResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextResponse extends BasicResponse{
    private final String text;
    
    public TextResponse(final String httpStatus, final String error, final String text){
        super(httpStatus, error);
        this.text = text;
    }
}
