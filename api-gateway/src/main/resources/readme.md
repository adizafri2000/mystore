Sure! Let's break down the contents of the `application.yml` file for your API Gateway and explain why each part is written that way.

### `application.yml` Breakdown

#### Application Name
```yaml
spring:
  application:
    name: api-gateway
```
- **Purpose**: Sets the name of the application to `api-gateway`. This is useful for identification in logs and when registering with Eureka.

#### Config Server Import
```yaml
  config:
    import: optional:configserver:http://localhost:8888  # Make the config server optional
```
- **Purpose**: Configures the application to fetch its configuration from a Config Server running at `http://localhost:8888`. The `optional` keyword means the application will still start even if the Config Server is not available.

#### Spring Cloud Gateway Discovery Locator
```yaml
  cloud:
    gateway:
      discovery:
        locator:
          lower-case-service-id: true
          enabled: true # enable routing based on service discovery
```
- **Purpose**: Enables the Spring Cloud Gateway to automatically create routes for services registered with Eureka. The `lower-case-service-id` ensures that service IDs are treated in lowercase.
- The `enabled` flag enables routing based on service discovery. 

##### Manual Route Configuration
For custom configuration of the routing and not to rely on service discovery, you can manually configure the routes. In this example, we have routes for `product-service`, `order-service`, and `customer-service`. Each route is configured with the following properties:
```yaml
    cloud:
    gateway:
      discovery:
        locator:
          lower-case-service-id: true
    routes:
      - id: product-service
        uri: lb://product-service
        predicates:
          - Path=/product-service/**
        filters:
          - RewritePath=/product-service/(?<remaining>.*), /${remaining}
      - id: order-service
        uri: lb://order-service
        predicates:
          - Path=/order-service/**
        filters:
          - RewritePath=/order-service/(?<remaining>.*), /${remaining}
      - id: customer-service
        uri: lb://customer-service
        predicates:
          - Path=/customer-service/**
        filters:
          - RewritePath=/customer-service/(?<remaining>.*), /${remaining}
```
- Define each route within the routes section.
- `id`: A unique identifier for the route.
- `uri`: The URI to which the route should be forwarded. The `lb://` prefix indicates that the request should be load-balanced across instances of the service.
- `predicates`: Conditions that must be met for the route to be applied. In this case, the route is applied if the request path starts with `/product-service/`, `/order-service/`, or `/customer-service/`.
- `filters`: Actions to be taken on the request or response. In this case, the `RewritePath` filter removes the service name from the request path before forwarding it to the service.
  - In this project example, `filters` are used as I need to test the APIs on each service on its root endpoint
  - Without this filter, e.g. since I did not create a `/product-service` endpoint in product service, calling localhost:8080/product-service (or with the trailing slash) will result in API request successfully forwarded to the product service, but fail due to non-existing endpoint `/product-service` in the product service.

#### Eureka Client Configuration
```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
- **Purpose**: Configures the Eureka client to register with the Eureka Server running at `http://localhost:8761/eureka/`. This allows the API Gateway to discover other services registered with Eureka.

#### Server Port
```yaml
server:
  port: 8080
```
- **Purpose**: Sets the port on which the API Gateway will run.


### Summary
The `application.yml` file configures the API Gateway to:
1. Identify itself as `api-gateway`.
2. Optionally fetch configuration from a Config Server.
3. Enable automatic route creation based on service discovery.
4. Register with a Eureka Server for service discovery.
5. Run on port `8080`.