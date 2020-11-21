package com.jmarczyk.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.jmarczyk.container.StatsContainer;

@Testcontainers
class TestContainerControllerTest
{
  @Container
  private static final StatsContainer statsContainer = new StatsContainer();

  @Test
  void testContainerIsRunning() {
    assertThat( statsContainer.isRunning() ).isTrue();
  }
}