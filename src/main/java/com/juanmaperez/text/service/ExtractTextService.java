package com.juanmaperez.text.service;

import com.juanmaperez.text.extractors.WebArticlesTextExtractor;
import com.juanmaperez.text.model.TextResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExtractTextService{
    
    private final WebArticlesTextExtractor webArticlesTextExtractor;
    
    public ExtractTextService(final WebArticlesTextExtractor webArticlesTextExtractor){
        this.webArticlesTextExtractor = webArticlesTextExtractor;
    }
    
    public TextResponse extractText(final String url){
        final var document = webArticlesTextExtractor.getDocument(url);
        final var text = webArticlesTextExtractor.transform(document);
        // TODO: Validar respuesta para devolver error o no
        return new TextResponse(HttpStatus.OK, null, text);
    }
}
