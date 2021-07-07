package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class DBConfig extends Config {
  private final String drivers;

  public DBConfig(Properties properties) {
    super(properties);
    this.drivers = update(ConfigKeys.DB.DRIVERS, "drivers");
  }

  @Override
  public String toString() {
    return "{" + "\"drivers\":\"" + drivers + "\"" + "}";
  }
}
