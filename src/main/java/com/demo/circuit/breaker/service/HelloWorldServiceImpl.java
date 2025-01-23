package com.demo.circuit.breaker.service;

import com.demo.circuit.breaker.configuration.HelloWorldClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorld {

    private final HelloWorldClient helloWorldClient;

    public HelloWorldServiceImpl(HelloWorldClient helloWorldClient) {
        this.helloWorldClient = helloWorldClient;
    }

    @Override
    @CircuitBreaker(name = "getHelloWorld", fallbackMethod = "helloWorldError")
    public String getHelloWorld() {
        return helloWorldClient.getHelloWorld();
    }

    public String helloWorldError(Exception t) {
        return "An error occurred while trying to get the hello world message: " + t.getMessage();
    }
}
