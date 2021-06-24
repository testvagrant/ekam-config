package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import static com.testvagrant.ekam.config.models.ConfigKeys.Ekam.ENV;
import static com.testvagrant.ekam.config.models.ConfigKeys.Ekam.LOCALE;

@Getter
@Setter
public class Ekam extends Config {
  private String env;
  private Mobile mobile;
  private Web web;
  private Integrations integrations;
  private Dashboard dashboard;
  private String locale;

  public Ekam(Properties ekamProperties) {
    super(ekamProperties);
    this.env = update(ENV, "");
    this.locale = update(LOCALE, "en");
    this.mobile = new Mobile(ekamProperties);
    this.web = new Web(ekamProperties);
    this.integrations = new Integrations(ekamProperties);
    this.dashboard = new Dashboard(ekamProperties);
  }

  @Override
  public String toString() {
    return "{"
        + "\"env\":\""
        + env
        + "\""
        + ", \"mobile\":"
        + mobile
        + ", \"web\":"
        + web
        + ", \"integrations\":"
        + integrations
        + ", \"dashboard\":"
        + dashboard
        + ", \"locale\":\""
        + locale
        + "\""
        + "}";
  }
}
