package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class ApiConfig extends Config {
  private final String hosts;

  public ApiConfig(Properties properties) {
    super(properties);
    this.hosts = setProperty(ConfigKeys.Api.HOSTS, "hosts");
  }

  @Override
  public String toString() {
    return "{" + "\"hosts\":\"" + hosts + "\"" + "}";
  }
}
