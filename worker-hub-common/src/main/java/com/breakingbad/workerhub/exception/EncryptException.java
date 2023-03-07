package com.breakingbad.workerhub.exception;

public class EncryptException extends RuntimeException {

    public EncryptException() {
        super();
    }

    public EncryptException(String message) {
        super(message);
    }

    public EncryptException(Throwable cause) {
        super(cause);
    }

}
