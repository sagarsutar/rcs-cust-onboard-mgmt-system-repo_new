package com.tcl.assignemnt.config;

import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/****
 * This class has swagger configuration 
 * @author Sagar
 *
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI rcsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RCS Customer Onboarding API")
                        .description("APIs for Customer onboarding workflow")
                        .version("1.0.0"));
    }
}