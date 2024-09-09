package com.fc_cryptoautomation.service;

import com.fc_cryptoautomation.http.SlackHttpClient;
import com.fc_cryptoautomation.http.UpBitHttpClient;
import com.fc_cryptoautomation.http.UpBitTickerDto;
import com.fc_cryptoautomation.repository.ReportHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpBitSlackService {

    private final SlackHttpClient slackHttpClient;
    private final UpBitHttpClient upBitHttpClient;
    private final ReportHistoryRepository reportHistoryRepository;

    public void execute(String market) {
        // upbit
        UpBitTickerDto tickerByMarket = upBitHttpClient.getTickerByMarket(market);

        // slack
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터] ");
        sb.append(market);
        sb.append(" price = ");
        sb.append(tickerByMarket.getTrade_price());
        slackHttpClient.send(sb.toString());

        reportHistoryRepository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }
}
