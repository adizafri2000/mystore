package adi.learn.customerservice.DTO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity<T extends BaseResponse<?>> extends ResponseEntity<T> {
    public CustomResponseEntity(T body, HttpStatus status) {
        super(body, status);
    }

    public CustomResponseEntity(T body, HttpHeaders headers, HttpStatus status) {
        super(body, headers, status);
    }
}
