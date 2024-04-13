package com.juanmaperez.text.service;

import com.juanmaperez.common.utils.ValidatorNotNull;
import com.juanmaperez.common.utils.ValidatorRegex;
import com.juanmaperez.text.extractors.WebArticlesTextExtractor;
import com.juanmaperez.text.model.TextResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExtractTextService{

    private final String URL_REGEX = "^(https?|ftp)://[a-zA-Z0-9.-]+(\\.[a-zA-Z]{2,})?(:[0-9]+)?(/\\S*)?$";
    private final String ERROR = "La url no es válida, reviselo por favor y vuelva a intentarlo";
    private final WebArticlesTextExtractor webArticlesTextExtractor;
    private final ValidatorNotNull validatorNotNull;
    private final ValidatorRegex validatorRegex;

    public ExtractTextService(final WebArticlesTextExtractor webArticlesTextExtractor,
            final ValidatorNotNull validatorNotNull, final ValidatorRegex validatorRegex){
        this.webArticlesTextExtractor = webArticlesTextExtractor;
        this.validatorNotNull = validatorNotNull;
        this.validatorRegex = validatorRegex;
    }

    public TextResponse extractText(final String url){
        if(isValid(url)){
            final var document = webArticlesTextExtractor.getDocument(url);
            final var text = webArticlesTextExtractor.transform(document);
            return new TextResponse(HttpStatus.OK, null, text);
        }
        return new TextResponse(HttpStatus.BAD_REQUEST, ERROR, null);
    }

    private boolean isValid(final String url){
        return validatorNotNull.validate(url) && validatorRegex.validate(URL_REGEX, url);
    }
}
