package com.juanmaperez.text.service;

import com.juanmaperez.common.utils.ValidatorNotNull;
import com.juanmaperez.common.utils.ValidatorRegex;
import com.juanmaperez.text.extractors.WebArticlesTextExtractor;
import com.juanmaperez.text.model.TextResponse;
import dev.langchain4j.data.document.Document;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ExtractTextServiceTest{

    private final WebArticlesTextExtractor webArticlesTextExtractor = mock(WebArticlesTextExtractor.class);
    private final ValidatorNotNull validatorNotNull = mock(ValidatorNotNull.class);
    private final ValidatorRegex validatorRegex = mock(ValidatorRegex.class);
    private final ExtractTextService sut = new ExtractTextService(webArticlesTextExtractor, validatorNotNull,
            validatorRegex);

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