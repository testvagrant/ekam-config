package com.testvagrant.ekam.config.models;

import java.util.Properties;

import static com.testvagrant.ekam.config.models.ConfigKeys.Locale.DIR;
import static com.testvagrant.ekam.config.models.ConfigKeys.Locale.LOCALE;

public class LocaleConfig extends Config {
  private final String dir;
  private final String locale;

  public LocaleConfig(Properties properties) {
    super(properties);
    this.locale = update(LOCALE, "en");
    this.dir = update(DIR, "");
  }

  @Override
  public String toString() {
    return "{" + "\"dir\":\"" + dir + "\"" + ", \"locale\":\"" + locale + "\"" + "}";
  }
}
