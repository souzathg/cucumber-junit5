package br.com.vericode.service;

import br.com.vericode.data.Calculator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class CalculatorService {
    public Mono<ServerResponse> sum(ServerRequest request) {
        Mono<Calculator> calculator = request.bodyToMono(Calculator.class);

        return calculator.map(c -> c.getNum1() + c.getNum2()).flatMap(r -> ServerResponse.status(HttpStatus.OK).bodyValue(r));
    }

    public Mono<ServerResponse> divide(ServerRequest request) {
        Mono<Calculator> calculator = request.bodyToMono(Calculator.class);

        return calculator.map(c -> c.getNum1() / c.getNum2()).flatMap(r -> ServerResponse.status(HttpStatus.OK).bodyValue(r));
    }

    public Mono<ServerResponse> healthCheck(ServerRequest request) {
        return ServerResponse.status(HttpStatus.OK).bodyValue("The application is running");
    }
}
