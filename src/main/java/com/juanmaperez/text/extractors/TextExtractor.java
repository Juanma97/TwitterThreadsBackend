package com.juanmaperez.text.extractors;

import dev.langchain4j.data.document.Document;

public interface TextExtractor{

    Document getDocument(final String url);
    String transform(final Document document);
}
