package com.jmarczyk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import com.jmarczyk.service.TestService;

@RestController
@RequiredArgsConstructor
public class TestController {
    @Autowired
    public TestService testService;

    @GetMapping(path = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> testController() {
        return Mono.just(testService.getTest());
    }
}