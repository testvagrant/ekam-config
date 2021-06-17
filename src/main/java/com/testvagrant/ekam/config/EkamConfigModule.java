package com.testvagrant.ekam.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class EkamConfigModule extends AbstractModule {
  private String DEFAULT_CONFIG_PATH =
      Paths.get(System.getProperty("user.dir"), "config", "default.properties").toString();

  private String CURRENT_CONFIG_PATH =
      Paths.get(
              System.getProperty("user.dir"),
              "config",
              System.getProperty("config", "default") + ".properties")
          .toString();

  public EkamConfigModule() {}

  public EkamConfigModule(String configFolderName) {
    DEFAULT_CONFIG_PATH =
        Paths.get(System.getProperty("user.dir"), configFolderName, "default.properties")
            .toString();
    CURRENT_CONFIG_PATH =
        Paths.get(
                System.getProperty("user.dir"),
                configFolderName,
                System.getProperty("config", "default") + ".properties")
            .toString();
  }

  public EkamConfigModule(Path configFolderPath) {
    DEFAULT_CONFIG_PATH = Paths.get(configFolderPath.toString(), "default.properties").toString();
    CURRENT_CONFIG_PATH =
        Paths.get(
                configFolderPath.toString(),
                System.getProperty("config", "default") + ".properties")
            .toString();
  }

  @Override
  protected void configure() {
    Properties properties = loadConfig();
    Names.bindProperties(binder(), properties);
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
