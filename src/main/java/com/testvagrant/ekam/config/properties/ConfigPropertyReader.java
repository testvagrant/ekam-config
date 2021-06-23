package com.testvagrant.ekam.config.properties;

import java.util.Objects;
import java.util.Properties;

public class ConfigPropertyReader {

  private static Properties properties;

  public static void read(Properties properties) {
    ConfigPropertyReader.properties = properties;
  }

  public static String update(String property, String defaultValue) {
    return updateProperty(property, getValidProperty(properties.getProperty(property), defaultValue));
  }

  public static boolean update(String property, boolean defaultValue) {
    return Boolean.parseBoolean(updateProperty(property, getValidProperty(properties.getProperty(property), String.valueOf(defaultValue))));
  }

  public static String updateProperty(String property, String defaultValue) {
    String value = System.getProperty(property, "");
    if(value.isEmpty() || value.equalsIgnoreCase("any")) {
      if(Objects.isNull(defaultValue)) defaultValue = "";
      System.setProperty(property, defaultValue);
      return defaultValue;
    } else {
      return value;
    }
  }

  public static String getValidProperty(String value, String defaultValue) {
    return Objects.isNull(value) ? defaultValue : value;
  }
}
