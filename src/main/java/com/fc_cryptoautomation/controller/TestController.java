package com.fc_cryptoautomation.controller;

import com.fc_cryptoautomation.service.UpbitSlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UpbitSlackService upbitSlackService;

    @GetMapping("/api/v1/ticker/{market}")
    public void test(@PathVariable String market) {
        upbitSlackService.execute(market);
    }
}
