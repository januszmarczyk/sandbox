package com.jmarczyk.controller;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import lombok.extern.slf4j.Slf4j;

@Testcontainers
@Slf4j
class StatsServiceContainerTest
{
  @Container
  private static final GenericContainer statsService = new GenericContainer( "sandbox_app_statistics:latest" ).withImagePullPolicy( PullPolicy.defaultPolicy() )
                                                                                                              .withExposedPorts( 8090 );

  @Test
  void testContainerIsRunning() {
    assertThat( statsService.isRunning() ).isTrue();
  }

  @Test
  void testContainerStatsResponse() throws IOException, InterruptedException {
    String host = statsService.getHost();
    Integer port = statsService.getFirstMappedPort();

    log.info( format( "Service config, host:%s, port:%d.", host, port ) );

    HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri( URI.create( format( "http://localhost:%d/test", port ) ) ).build();
    HttpResponse<String> response = HttpClient.newHttpClient().send( httpRequest, HttpResponse.BodyHandlers.ofString() );

    assertThat( response.body() ).isEqualTo( "XD" );
  }
}