package com.juanmaperez.threads.service;

import com.juanmaperez.common.ia.ThreadsAgent;
import com.juanmaperez.common.utils.ValidatorNotNull;
import com.juanmaperez.threads.model.ThreadsResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThreadsService{
    private final String AGENT_ACTION_1 = "Haz un hilo para Twitter con el siguiente texto: ";
    private final String AGENT_ACTION_2 = "\n Separa los hilos con saltos de linea";
    private final String ERROR = "El texto para crear el hilo no es válido, reviselo y vuelvalo a intentar por favor";
    private final ValidatorNotNull validatorNotNull;
    private final ThreadsAgent threadsAgent;

    public ThreadsService(final ThreadsAgent threadsAgent, final ValidatorNotNull validatorNotNull){
        this.threadsAgent = threadsAgent;
        this.validatorNotNull = validatorNotNull;
    }

    public ThreadsResponse convertToThread(final String text){
        if(isValid(text)){
            final String response = threadsAgent.chat(AGENT_ACTION_1 + text + AGENT_ACTION_2);
            final List<String> thread = getThread(response);
            return new ThreadsResponse(HttpStatus.OK, null, thread);
        }

        return new ThreadsResponse(HttpStatus.BAD_REQUEST, ERROR, null);
    }

    private List<String> getThread(String response){
        return Arrays.stream(response.split("\\n"))
                .filter(chunk -> !chunk.isEmpty())
                .collect(Collectors.toList());
    }

    private boolean isValid(final String text){
        return validatorNotNull.validate(text);
    }
}
