package com.jmarczyk.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
@Slf4j
public class TestContainerController
{
  private final HttpClient httpClient = HttpClient.newHttpClient();

  @GetMapping
  public Mono<String> test() {
    log.info( "Invoked controller test method." );

    HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri( URI.create( "http://localhost:8090/stats" ) ).build();
    httpClient.sendAsync( httpRequest, HttpResponse.BodyHandlers.discarding() );
    log.info( "Sent update with stats." );

    return Mono.just( "It's a good day to check testcontainers lib." );
  }
}