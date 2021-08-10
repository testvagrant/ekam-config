package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import static com.testvagrant.ekam.config.models.ConfigKeys.Env.BASE_ENV;

@Getter
@Setter
public class EnvConfig extends Config {
  private String env;
  private String webEnv;
  private String mobileEnv;
  private String apiEnv;
  private String dbEnv;
  private String dataSetsEnv;
  private String localeEnv;

  public EnvConfig(Properties properties) {
    super(properties);
    this.env = setProperty(BASE_ENV, "");
    this.webEnv = setProperty(ConfigKeys.Env.WEB_ENV, this.env);
    this.mobileEnv = setProperty(ConfigKeys.Env.MOBILE_ENV, this.env);
    this.apiEnv = setProperty(ConfigKeys.Env.API_ENV, this.env);
    this.dbEnv = setProperty(ConfigKeys.Env.DB_ENV, this.env);
    this.dataSetsEnv = setProperty(ConfigKeys.Env.DATASETS_ENV, this.env);
    this.localeEnv = setProperty(ConfigKeys.Env.LOCALE_ENV, this.env);
  }

  @Override
  public String toString() {
    return "{"
        + "\"env\":\""
        + env
        + "\""
        + ", \"webEnv\":\""
        + webEnv
        + "\""
        + ", \"mobileEnv\":\""
        + mobileEnv
        + "\""
        + ", \"apiEnv\":\""
        + apiEnv
        + "\""
        + ", \"dbEnv\":\""
        + dbEnv
        + "\""
        + ", \"dataSetsEnv\":\""
        + dataSetsEnv
        + "\""
        + ", \"localeEnv\":\""
        + localeEnv
        + "\""
        + "}";
  }
}
