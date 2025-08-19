package adi.learn.customerservice.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ServiceTemplate {

    public static <Request, Response> Response execute(Request request, ServiceCallback<Request, Response> callback) {
        Response response = callback.createDefaultResponse();

        try {
            log.info("Executing service logic for request: {}", request);
            callback.checkParams(request);
            callback.process(request, response);
            log.info("Service execution successful for request: {}", request);
        } catch (Exception e) {
            // Log the full exception, not just the message, for effective debugging.
            log.error("Service execution failed for request: {}", request, e);
            callback.createErrorResponse(response);
        }

        return response;
    }
}
