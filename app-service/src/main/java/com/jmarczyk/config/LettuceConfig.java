package com.jmarczyk.config;

import io.lettuce.core.ReadFrom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class LettuceConfig {

  @Bean
  public LettuceConnectionFactory redisConnectionFactory() {
    //    #on the same machine UNIX socket can be reused
    //    #configure permissions: which user can access socket,
    //    #add volume to reuse socket between containers
    //    return new LettuceConnectionFactory(new RedisSocketConfiguration("/var/run/redis.sock"));
    RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("localhost", 6379);
    LettuceClientConfiguration lettuceConfig = LettuceClientConfiguration.builder().readFrom(ReadFrom.REPLICA_PREFERRED).build();

    return new LettuceConnectionFactory(redisConfig, lettuceConfig);
  }
}
