package com.juanmaperez.text.extractors;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.transformer.HtmlTextExtractor;
import org.springframework.stereotype.Component;

@Component
public class WebArticlesTextExtractor implements TextExtractor{
    
    public Document getDocument(final String url){
        return UrlDocumentLoader.load(url, new TextDocumentParser());
    }

    public String transform(final Document document){
        return new HtmlTextExtractor(null, null, false).transform(document).text();
    }
}
