package com.juanmaperez.summary.controller;

import com.juanmaperez.summary.model.SummarizeResponse;
import com.juanmaperez.summary.service.SummaryService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class SummaryControllerTest{
    
    private final String text = "text";
    private final String summarizedText = "txt";
    private final SummaryService summaryService = mock(SummaryService.class);
    private final SummaryController sut = new SummaryController(summaryService);
    
    @Test
    void shouldReturnSummarizeResponseWhenCallService(){
        final SummarizeResponse summarizeResponse = new SummarizeResponse(HttpStatus.OK, null, summarizedText);
        when(summaryService.summarize(text)).thenReturn(summarizeResponse);

        final SummarizeResponse response = sut.summarize(text);
        
        assertThat(response.getSummary(), is(summarizedText));
        assertThat(response.getHttpStatus().is2xxSuccessful(), is(true));
        assertThat(response.getError(), is(nullValue()));
        verify(summaryService).summarize(text);
    }

}