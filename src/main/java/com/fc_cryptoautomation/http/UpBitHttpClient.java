package com.fc_cryptoautomation.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpBitHttpClient {

    private final HttpClient httpClient;

    public UpBitTickerDto getTickerByMarket(String market) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");

        String URI = "https://api.upbit.com/v1/ticker?markets=" + market;

        String execute = httpClient.execute(
                URI, HttpMethod.GET, httpHeaders
        );

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                execute,
                new TypeReference<List<UpBitTickerDto>>() {}
        ).stream().findFirst().get();
    }
}
