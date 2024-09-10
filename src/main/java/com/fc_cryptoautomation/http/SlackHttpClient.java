package com.fc_cryptoautomation.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackHttpClient {

    String WEBHOOK = "https://hooks.slack.com/services/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";

    public void send(String message) {
        try {
            Slack instance = Slack.getInstance();

            // payload (요청을 보낼 데이터) 생성
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send(WEBHOOK, payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
