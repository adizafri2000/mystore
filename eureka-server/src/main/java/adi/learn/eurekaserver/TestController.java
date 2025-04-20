package adi.learn.eurekaserver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

//    @Value("${custom.message:Default message}")
    private String customMessage;

//    @Value("${eureka.instance.hostname}")
    private String hostname;

    public TestController() {
        log.info("TestController created, customMessage: {}", customMessage);
    }

    @GetMapping("/custom-message")
    public String getCustomMessage() {
        log.info("Returning custom message: {}", customMessage);
        return customMessage;
    }

    @GetMapping("/hostname")
    public String getHostname() {
        log.info("Returning hostname: {}", hostname);
        return hostname;
    }
}
