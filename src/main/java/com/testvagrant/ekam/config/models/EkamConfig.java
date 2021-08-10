package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class EkamConfig extends Config {
  private MobileConfig mobile;
  private EnvConfig environments;
  private WebConfig web;
  private IntegrationsConfig integrations;
  private DashboardConfig dashboardConfig;
  private LocaleConfig locale;
  private DBConfig db;
  private ApiConfig apiConfig;
  private DataSetsConfig dataSetsConfig;
  private CloudConfig cloudConfig;
  private LogConfig logConfig;

  public EkamConfig(Properties ekamProperties) {
    super(ekamProperties);
    this.environments = new EnvConfig(ekamProperties);
    this.mobile = new MobileConfig(ekamProperties);
    this.web = new WebConfig(ekamProperties);
    this.integrations = new IntegrationsConfig(ekamProperties);
    this.dashboardConfig = new DashboardConfig(ekamProperties);
    this.locale = new LocaleConfig(ekamProperties);
    this.cloudConfig = new CloudConfig(ekamProperties);
    this.db = new DBConfig(ekamProperties);
    this.apiConfig = new ApiConfig(ekamProperties);
    this.dataSetsConfig = new DataSetsConfig(ekamProperties);
    this.logConfig = new LogConfig(ekamProperties);
  }

  @Override
  public String toString() {
    return "EkamConfig{"
        + "mobile="
        + mobile
        + ", environments="
        + environments
        + ", web="
        + web
        + ", integrations="
        + integrations
        + ", dashboardConfig="
        + dashboardConfig
        + ", locale="
        + locale
        + ", db="
        + db
        + ", apiConfig="
        + apiConfig
        + ", dataSetsConfig="
        + dataSetsConfig
        + ", cloudConfig="
        + cloudConfig
        + ", logConfig="
        + logConfig
        + '}';
  }
}
