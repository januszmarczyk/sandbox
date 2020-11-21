package com.jmarczyk.container;

import org.testcontainers.lifecycle.Startable;

public class StatsContainer implements Startable
{
  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }

  public boolean isRunning() {
    return true;
  }
}