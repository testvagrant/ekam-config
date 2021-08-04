package com.testvagrant.ekam.config.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigPropertyLoader {

    private final String DEFAULT_CONFIG_PATH;
    private final String CURRENT_CONFIG_PATH;

    public ConfigPropertyLoader() {
        this.DEFAULT_CONFIG_PATH =
                Paths.get(System.getProperty("user.dir"), "config", "default.properties").toString();
        this.CURRENT_CONFIG_PATH =
                Paths.get(
                                System.getProperty("user.dir"),
                                "config",
                                System.getProperty("config", "default") + ".properties")
                        .toString();
    }

    public ConfigPropertyLoader(String configName) {
        DEFAULT_CONFIG_PATH =
                Paths.get(System.getProperty("user.dir"), "config", "default.properties").toString();
        CURRENT_CONFIG_PATH =
                Paths.get(System.getProperty("user.dir"), "config", configName + ".properties").toString();
    }

    public ConfigPropertyLoader(Path configFolderPath) {
        DEFAULT_CONFIG_PATH = Paths.get(configFolderPath.toString(), "default.properties").toString();
        CURRENT_CONFIG_PATH =
                Paths.get(
                                configFolderPath.toString(),
                                System.getProperty("config", "default") + ".properties")
                        .toString();
    }

    public Properties loadConfig() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(DEFAULT_CONFIG_PATH));
            properties.load(new FileInputStream(CURRENT_CONFIG_PATH));
        } catch (IOException e) {
            return properties;
        }
        return properties;
    }
}
