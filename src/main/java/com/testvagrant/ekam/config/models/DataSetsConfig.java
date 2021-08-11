package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class DataSetsConfig extends Config {
  private final String dir;

  public DataSetsConfig(Properties properties) {
    super(properties);
    this.dir = setProperty(ConfigKeys.DATASETS.DIR, "");
    setProperty(ConfigKeys.DATASETS.CACHE_SIZE, "");
  }

  @Override
  public String toString() {
    return "DataSetsConfig{" + "dir='" + dir + '\'' + '}';
  }
}
