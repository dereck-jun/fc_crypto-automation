package com.fc_cryptoautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FcCryptoAutomationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FcCryptoAutomationApplication.class, args);
        SpringApplication.exit(run);    // batch job이기 때문에 SpringApplication이 종료될 수 있게 변경
    }

}
