package br.com.vericode.controller;

import br.com.vericode.service.CalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class CalculatorController {

    @Bean
    public RouterFunction<ServerResponse> calculator(CalculatorService service) {
        return RouterFunctions.route(POST("/sum"), service::sum)
                                .andRoute(POST("/divide"), service::divide)
                                .andRoute(GET("/health"), service::healthCheck);
    }
}
