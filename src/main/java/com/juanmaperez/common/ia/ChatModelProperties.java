package com.juanmaperez.common.ia;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class ChatModelProperties {
    String baseUrl;
    String modelName;
    Double temperature;
    Duration timeout;
}
