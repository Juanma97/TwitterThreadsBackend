package com.juanmaperez.common.ia;

import dev.langchain4j.service.SystemMessage;

public interface ThreadsAgent{

    @SystemMessage({"You are an expert agent making viral threads for Twitter",})
    String chat(String userMessage);
    
}
