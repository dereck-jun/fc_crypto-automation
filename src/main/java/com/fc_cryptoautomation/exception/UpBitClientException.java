package com.fc_cryptoautomation.exception;

public class UpBitClientException extends RuntimeException {
    public UpBitClientException() {
        super();
    }

    public UpBitClientException(String message) {
        super(String.format("UpBit API 호출 중 에러 발생. ERROR=%s", message));
    }

    public UpBitClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpBitClientException(Throwable cause) {
        super(cause);
    }
}
