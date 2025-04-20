package adi.learn.customerservice.util.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    SUCCESS("00", "Success"),
    FAILED("01", "Failed"),
    INVALID_REQUEST("02", "Invalid Request"),
    IDEMPOTENCY_FAILED("03", "Idempotency Failed"),
    NOT_FOUND("04", "Not Found"),
    UNAUTHORIZED("05", "Unauthorized"),
    INTERNAL_SERVER_ERROR("06", "Internal Server Error");

    private final String code;
    private final String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
