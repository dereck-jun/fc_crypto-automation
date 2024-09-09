package com.fc_cryptoautomation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "report_history")
public class ReportHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_history_id")
    private int id;

    @Column
    private String market;

    @Column
    private String price;

    @Column
    private LocalDateTime reportedAt;

    public ReportHistory(String market, String price) {
        this.market = market;
        this.price = price;
        this.reportedAt = LocalDateTime.now();
    }
}
