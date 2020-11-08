package com.jmarczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class AppServer {
  public static void main(String[] args) {
    SpringApplication.run(AppServer.class, args);
  }
}
