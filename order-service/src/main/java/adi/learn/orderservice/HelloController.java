package adi.learn.orderservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    public Response sayHello() {
        log.debug("reached sayHello method endpoint in Order API Service");
        return new Response("Hello from Order API Service");
    }

    static record Response(String message) {}
}
