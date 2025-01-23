package com.demo.circuit.breaker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HelloWorldServiceImpl implements HelloWorld {

    private final WebClient webClient;

    public HelloWorldServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String getHelloWorld() {
        return webClient.get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
