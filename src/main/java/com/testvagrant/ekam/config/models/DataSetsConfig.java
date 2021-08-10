package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class DataSetsConfig extends Config {
  private final String dir;

  public DataSetsConfig(Properties properties) {
    super(properties);
    this.dir = setProperty(ConfigKeys.DATASETS.DIR, "");
  }

  @Override
  public String toString() {
    return "{" + "\"dir\":\"" + dir + "\"" + "}";
  }
}
