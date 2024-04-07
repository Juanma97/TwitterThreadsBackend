package com.juanmaperez.text.service;

import com.juanmaperez.text.extractors.WebArticlesTextExtractor;
import com.juanmaperez.text.model.TextResponse;
import dev.langchain4j.data.document.Document;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExtractTextServiceTest{
    
    private final WebArticlesTextExtractor webArticlesTextExtractor = mock(WebArticlesTextExtractor.class);
    private final ExtractTextService sut = new ExtractTextService(webArticlesTextExtractor);
    
    @Test
    void shouldExtractTextFromURL(){
        final var url = "https://example.com";
        final var expectedText = "Texto extraído de la página web";

        final var document = mock(Document.class);
        when(webArticlesTextExtractor.getDocument(url)).thenReturn(document);
        when(webArticlesTextExtractor.transform(document)).thenReturn(expectedText);

        final TextResponse textResponse = sut.extractText(url);

        assertEquals(expectedText, textResponse.getText());
        assertNull(textResponse.getError());
        assertEquals(HttpStatus.OK, textResponse.getHttpStatus());
        verify(webArticlesTextExtractor).getDocument(url);
        verify(webArticlesTextExtractor).transform(document);
    }

}