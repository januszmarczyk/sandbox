package com.jmarczyk.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private String id;
  private String name;
  private String description;
  private MetricType metricType;
  private int metricValue;
}