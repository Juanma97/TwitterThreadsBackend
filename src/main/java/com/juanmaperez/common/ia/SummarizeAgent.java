package com.juanmaperez.common.ia;

import dev.langchain4j.service.SystemMessage;

public interface SummarizeAgent{

    @SystemMessage({"You are an expert agent making resumes in 500 words of articles",})
    String chat(String userMessage);
    
}
