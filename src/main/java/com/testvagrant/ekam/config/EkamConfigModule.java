package com.testvagrant.ekam.config;

import com.google.inject.AbstractModule;
import com.testvagrant.ekam.config.models.Ekam;
import com.testvagrant.ekam.config.properties.ConfigPropertyLoader;

import java.util.Properties;

public class EkamConfigModule extends AbstractModule {

  @Override
  protected void configure() {
    Properties properties = new ConfigPropertyLoader().loadConfig();
    Ekam ekam = new Ekam(properties);
    bind(Ekam.class).toInstance(ekam);
  }
}
