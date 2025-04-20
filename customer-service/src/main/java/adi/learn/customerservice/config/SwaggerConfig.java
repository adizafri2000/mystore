package adi.learn.customerservice.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration class
 */
@Configuration
public class SwaggerConfig {

    @Value("${springdoc.openapi.title}")
    private String title;

    @Value("${springdoc.openapi.version}")
    private String version;

    @Value("${springdoc.openapi.description}")
    private String description;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description));
    }
}


