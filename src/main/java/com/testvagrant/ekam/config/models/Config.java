package com.testvagrant.ekam.config.models;

import java.util.Objects;
import java.util.Properties;

public abstract class Config {

    private Properties properties;

    public Config(Properties properties) {
        this.properties = properties;
    }

    public String update(String property, String defaultValue) {
        return updateProperty(property, getValidProperty(properties.getProperty(property), defaultValue));
    }

    public boolean update(String property, boolean defaultValue) {
        return Boolean.parseBoolean(updateProperty(property, getValidProperty(properties.getProperty(property), String.valueOf(defaultValue))));
    }

    public String updateProperty(String property, String defaultValue) {
        String value = System.getProperty(property, "");
        if(value.isEmpty() || value.equalsIgnoreCase("any")) {
            if(Objects.isNull(defaultValue)) defaultValue = "";
            System.setProperty(property, defaultValue);
            return defaultValue;
        } else {
            return value;
        }
    }

    public String getValidProperty(String value, String defaultValue) {
        return Objects.isNull(value) ? defaultValue : value;
    }
}
