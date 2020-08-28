package com.jmarczyk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class TestService {

    public String getTest() {
        log.info("Sending async request to update stats.");
        HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8090/stats")).build();
        HttpClient.newHttpClient().sendAsync(httpRequest, HttpResponse.BodyHandlers.discarding());
        return "HELLO WORLD";
    }
}
