package com.jmarczyk.data;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Product")
public class Product {
  private String id;
  private String name;
  private String description;
  private MetricType metricType;
  private int metricValue;
}