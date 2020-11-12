package com.jmarczyk.config;

import com.jmarczyk.data.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import io.lettuce.core.ReadFrom;

@Configuration
public class RedisConfig {

  @Bean
  @Primary
  public ReactiveRedisConnectionFactory createRedisConnectionFactory() {
    // TODO
    //    on the same machine UNIX socket can be reused
    //    configure permissions: which user can access socket,
    //    add volume to reuse socket between containers
    //    return new LettuceConnectionFactory(new RedisSocketConfiguration("/var/run/redis.sock"));
    RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration( "localhost", 6379);
    LettuceClientConfiguration lettuceConfig = LettuceClientConfiguration.builder().readFrom( ReadFrom.REPLICA_PREFERRED ).build();

    return new LettuceConnectionFactory( redisConfig, lettuceConfig);
  }

  @Bean
  public ReactiveRedisOperations<String, Product> redisProductOperations(ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<Product> productSerializer = new Jackson2JsonRedisSerializer<>(Product.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Product> builder = RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, Product> context = builder.value(productSerializer).build();

    return new ReactiveRedisTemplate<>(factory, context);
  }
}