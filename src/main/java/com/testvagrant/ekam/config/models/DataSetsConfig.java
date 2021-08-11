package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class DataSetsConfig extends Config {
  private final String dir;
  private final int cacheSize;

  public DataSetsConfig(Properties properties) {
    super(properties);
    this.dir = setProperty(ConfigKeys.DATASETS.DIR, "");
    this.cacheSize = Integer.parseInt(setProperty(ConfigKeys.DATASETS.CACHE_SIZE, "500"));
  }

  @Override
  public String toString() {
    return "DataSetsConfig{" + "dir='" + dir + '\'' + ", cacheSize=" + cacheSize + '}';
  }
}
