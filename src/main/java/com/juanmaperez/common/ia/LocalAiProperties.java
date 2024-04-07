package com.juanmaperez.common.ia;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Getter
@Setter
@ConfigurationProperties(prefix = LocalAiProperties.PREFIX)
public class LocalAiProperties{

    static final String PREFIX = "langchain4j.local-ai";

    @NestedConfigurationProperty
    ChatModelProperties chatModel;
}
