package com.fc_cryptoautomation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fc_cryptoautomation.http.UpBitHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UpBitHttpClient upBitHttpClient;

    @GetMapping("/api/v1/ticker/{market}")
    public void test(@PathVariable String market) throws JsonProcessingException {
        upBitHttpClient.getTickerByMarket(market);
    }
}
