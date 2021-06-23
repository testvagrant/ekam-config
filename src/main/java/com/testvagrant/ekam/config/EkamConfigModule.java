package com.testvagrant.ekam.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.testvagrant.ekam.config.models.Ekam;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class EkamConfigModule extends AbstractModule {
  private String DEFAULT_CONFIG_PATH;

  private String CURRENT_CONFIG_PATH;

  public EkamConfigModule() {
    this.DEFAULT_CONFIG_PATH =
            Paths.get(System.getProperty("user.dir"), "config", "default.properties").toString();
    this.CURRENT_CONFIG_PATH =
            Paths.get(
                    System.getProperty("user.dir"),
                    "config",
                    System.getProperty("config", "default") + ".properties")
                    .toString();
  }

//  public EkamConfigModule(String configFolderName) {
//    DEFAULT_CONFIG_PATH =
//        Paths.get(System.getProperty("user.dir"), configFolderName, "default.properties")
//            .toString();
//    CURRENT_CONFIG_PATH =
//        Paths.get(
//                System.getProperty("user.dir"),
//                configFolderName,
//                System.getProperty("config", "default") + ".properties")
//            .toString();
//  }
//
//  public EkamConfigModule(Path configFolderPath) {
//    DEFAULT_CONFIG_PATH = Paths.get(configFolderPath.toString(), "default.properties").toString();
//    CURRENT_CONFIG_PATH =
//        Paths.get(
//                configFolderPath.toString(),
//                System.getProperty("config", "default") + ".properties")
//            .toString();
//  }

  @Override
  protected void configure() {
    Properties properties = loadConfig();
    Names.bindProperties(binder(), properties);
    Ekam ekam = new Ekam();
    requestInjection(ekam);
    bind(Ekam.class).toInstance(ekam);
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
