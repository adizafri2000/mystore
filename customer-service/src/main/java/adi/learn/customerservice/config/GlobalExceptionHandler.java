package adi.learn.customerservice.config;

import adi.learn.customerservice.DTO.BaseResponse;
import adi.learn.customerservice.DTO.CustomResponseEntity;
import adi.learn.customerservice.util.enums.ResponseEnum;
import adi.learn.customerservice.util.exception.IdempotencyFailureException;
import adi.learn.customerservice.util.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IdempotencyFailureException.class)
    public ResponseEntity<BaseResponse<?>> handleIdempotencyFailureException(IdempotencyFailureException e) {
        log.error("Idempotency failed: {}", e.getMessage());
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .responseCode(ResponseEnum.IDEMPOTENCY_FAILED.getCode())
                        .responseMessage(ResponseEnum.IDEMPOTENCY_FAILED.getMessage())
                        .data(e.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleUserNotExistException(ResourceNotFoundException e) {
        log.error("Resource not found: {}", e.getMessage());
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .responseCode(ResponseEnum.NOT_FOUND.getCode())
                        .responseMessage(ResponseEnum.NOT_FOUND.getMessage())
                        .data(e.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public CustomResponseEntity<BaseResponse<?>> handleGeneralException(Exception e) {
        log.error("Internal server error: {}", e.getMessage());
        return new CustomResponseEntity<>(
                BaseResponse.builder()
                        .responseCode(ResponseEnum.INTERNAL_SERVER_ERROR.getCode())
                        .responseMessage(ResponseEnum.INTERNAL_SERVER_ERROR.getMessage())
                        .data(e.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
