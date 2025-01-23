package com.demo.circuit.breaker.controller;

import com.demo.circuit.breaker.service.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorld helloWorld;

    @Autowired
    public HelloWorldController(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @GetMapping(value = "/greeting")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok(helloWorld.getHelloWorld());
    }


}
