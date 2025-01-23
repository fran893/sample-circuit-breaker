package com.demo.circuit.breaker.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "helloWorldClient", url = "http://localhost:8081")
public interface HelloWorldClient {

    @GetMapping("/hello")
    String getHelloWorld();
}
