package com.fc_cryptoautomation.controller;

import com.fc_cryptoautomation.service.UpBitSlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UpBitSlackService upBitSlackService;

    @GetMapping("/api/v1/ticker/{market}")
    public void test(@PathVariable String market) {
        upBitSlackService.execute(market);
    }
}
