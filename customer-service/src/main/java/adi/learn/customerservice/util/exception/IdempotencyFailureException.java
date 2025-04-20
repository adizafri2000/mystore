package adi.learn.customerservice.util.exception;

public class IdempotencyFailureException extends RuntimeException {
    public IdempotencyFailureException(String message) {
        super(message);
    }
}
