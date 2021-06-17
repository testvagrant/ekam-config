package com.testvagrant.ekam.config.utils;

import java.util.Objects;

public class EkamPropertyReader {

  public static String updateProperty(String property, String defaultValue) {
    String value = System.getProperty(property, "");
    return value.isEmpty() ? defaultValue : value;
  }

  public static boolean updateProperty(String property, boolean defaultValue) {
    boolean value = Boolean.parseBoolean(System.getProperty(property, "false"));
    return value ? value : defaultValue;
  }

  public static <T> T createInstance(T instance, Class<T> tClass) {
    try {
      return Objects.isNull(instance) ? tClass.newInstance() : instance;
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
  }
}
