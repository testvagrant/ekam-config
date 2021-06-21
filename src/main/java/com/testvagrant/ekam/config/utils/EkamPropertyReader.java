package com.testvagrant.ekam.config.utils;

import java.util.Objects;

public class EkamPropertyReader {

  public static String updateProperty(String property, String defaultValue) {
    String value = System.getProperty(property, "");
    if(value.isEmpty() || value.equalsIgnoreCase("any")) {
      System.setProperty(property, defaultValue);
      return defaultValue;
    } else {
      return value;
    }
  }

  public static boolean updateProperty(String property, boolean defaultValue) {
    boolean value = Boolean.parseBoolean(System.getProperty(property, "false"));
    if(value) {
      return value;
    } else {
      System.setProperty(property, String.valueOf(defaultValue));
      return defaultValue;
    }
  }

  public static <T> T createInstance(T instance, Class<T> tClass) {
    try {
      return Objects.isNull(instance) ? tClass.newInstance() : instance;
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
  }
}
