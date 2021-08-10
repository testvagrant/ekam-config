package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class DashboardConfig extends Config {
  private String dashboardUrl;

  public DashboardConfig(Properties properties) {
    super(properties);
    this.dashboardUrl = setProperty(ConfigKeys.DASHBOARD.URL, "");
  }

  public boolean publishToDashboard() {
    return !dashboardUrl.isEmpty();
  }

  @Override
  public String toString() {
    return "{" + "\"dashboardUrl\":\"" + dashboardUrl + "\"" + "}";
  }
}
