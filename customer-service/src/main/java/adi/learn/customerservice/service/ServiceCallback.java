package adi.learn.customerservice.service;

/**
 * Defines the steps for a specific service operation that will be executed
 * by the ServiceTemplate. This follows the Template Method pattern, allowing
 * for a consistent execution wrapper around custom business logic.
 *
 * @param <Request>  The request object type.
 * @param <Response> The response object type.
 */
public interface ServiceCallback<Request, Response> {

    /**
     * Validates the incoming request. Should throw an exception (e.g., IllegalArgumentException)
     * if validation fails. The ServiceTemplate will catch it and handle it gracefully.
     *
     * @param request The service request object.
     */
    default void checkParams(Request request) {
        // Default implementation does nothing. Override if validation is needed.
    }

    /**
     * The core business logic of the service operation. This method is responsible
     * for populating the provided response object.
     *
     * @param request  The service request object.
     * @param response The response object to be populated.
     */
    void process(Request request, Response response);

    /**
     * Creates a default or empty response object before processing begins.
     * @return A new response object.
     */
    Response createDefaultResponse();

    void createErrorResponse(Response response);

    void handleError(Request request, Exception e);
}
