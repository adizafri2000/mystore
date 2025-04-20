package adi.learn.customerservice.controller;

import adi.learn.customerservice.DTO.BaseResponse;
import adi.learn.customerservice.util.enums.ResponseEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public BaseResponse<String> sayHello() {
        return BaseResponse.<String>builder()
                .responseCode(ResponseEnum.SUCCESS.getCode())
                .responseMessage(ResponseEnum.SUCCESS.getMessage())
                .data("Customer service base endpoint reached!")
                .build();
    }
}
