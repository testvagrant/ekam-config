package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class CloudConfig extends Config {
  private final String dir;

  public CloudConfig(Properties properties) {
    super(properties);
    this.dir = update(ConfigKeys.Cloud.DIR, "cloud_config");
  }

  @Override
  public String toString() {
    return "{" + "\"dir\":\"" + dir + "\"" + "}";
  }
}
