package com.testvagrant.ekam.config.models;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Properties;

public abstract class Config {

  private final Properties properties;

  public Config(Properties properties) {
    this.properties = properties;
  }

  public String setProperty(String property, @Nonnull String defaultValue) {
    String propertyValue = properties.getProperty(property);
    propertyValue = Objects.isNull(propertyValue) ? defaultValue : propertyValue;

    String value = System.getProperty(property, "");
    if (value.isEmpty() || value.equalsIgnoreCase("any")) {
      System.setProperty(property, propertyValue);
      return propertyValue;
    } else {
      return value;
    }
  }

  public boolean setProperty(String property, boolean defaultValue) {
    String propertyValue = setProperty(property, String.valueOf(defaultValue));
    return Boolean.parseBoolean(propertyValue);
  }
}
