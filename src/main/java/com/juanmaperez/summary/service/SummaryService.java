package com.juanmaperez.summary.service;

import com.juanmaperez.common.ia.SummarizeAgent;
import com.juanmaperez.common.utils.ValidatorNotNull;
import com.juanmaperez.summary.model.SummarizeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SummaryService{
    private final String AGENT_ACTION = "Resume el siguiente texto en 500 palabras exactas";
    private final String ERROR = "El texto a resumir no es válido, reviselo y vuelvalo a intentar por favor";
    private final ValidatorNotNull validatorNotNull;
    private final SummarizeAgent summarizeAgent;

    public SummaryService(final ValidatorNotNull validatorNotNull, final SummarizeAgent summarizeAgent){
        this.validatorNotNull = validatorNotNull;
        this.summarizeAgent = summarizeAgent;
    }

    public SummarizeResponse summarize(final String text){
        if(isValid(text)){
            final String textCleaned = text.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\p{Punct}\\s\\[\\](){\\n}]", "");
            final String response = summarizeAgent.chat(AGENT_ACTION + textCleaned);
            return new SummarizeResponse(HttpStatus.OK, null, response);
        }
        return new SummarizeResponse(HttpStatus.BAD_REQUEST, ERROR, null);
    }

    private boolean isValid(final String text){
        return validatorNotNull.validate(text);
    }
}
