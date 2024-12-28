package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {

    public BestResultNotFound() {
        super();
    }

    public BestResultNotFound(String message) {
        super(message);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(Throwable cause) {
        super(cause);
    }
}
