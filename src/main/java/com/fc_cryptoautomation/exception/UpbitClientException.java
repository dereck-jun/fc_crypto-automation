package com.fc_cryptoautomation.exception;

public class UpbitClientException extends RuntimeException {
    public UpbitClientException() {
        super();
    }

    public UpbitClientException(String message) {
        super(String.format("UpBit API 호출 중 에러 발생. ERROR=%s", message));
    }

    public UpbitClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpbitClientException(Throwable cause) {
        super(cause);
    }
}
