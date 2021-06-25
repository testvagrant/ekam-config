package com.testvagrant.ekam.config;

import com.testvagrant.ekam.config.models.EkamConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EkamConfigTest {

  @Test
  public void whenConfigIsNotSetEkamShouldReadFromDefaultDotPropertiesFile() {
    EkamConfig ekamConfig =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(EkamConfig.class);
    Assert.assertEquals(ekamConfig.getEnvironments().getEnv(), "qa");
    Assert.assertEquals(ekamConfig.getMobile().getHub(), "");
  }

  @Test
  public void whenConfigIsSetEkamShouldReadFromConfigDotPropertiesFile() {
    System.setProperty("config", "remote");
    System.setProperty("env", "");
    System.setProperty("mobile.feed", "");
    EkamConfig ekamConfig =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(EkamConfig.class);
    Assert.assertEquals(ekamConfig.getEnvironments().getEnv(), "staging");
    Assert.assertEquals(ekamConfig.getMobile().getFeed(), "remoteTestFeed");
  }

  @Test
  public void whenConfigValueIsNotDefinedInPropertiesFileDefaultValueShouldBeLoaded() {
    System.setProperty("config", "remote");
    EkamConfig ekamConfig =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(EkamConfig.class);
    Assert.assertTrue(ekamConfig.getIntegrations().getSlack().isNotify());
    Assert.assertFalse(ekamConfig.getIntegrations().getSlack().isNotifyMeEveryTime());
  }

  @Test
  public void whenSpecificEnvsAreNotProvidedDefaultEnvShouldBeUsed() {
    System.setProperty("env", "");
    EkamConfig ekamConfig =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(EkamConfig.class);
    Assert.assertEquals(ekamConfig.getEnvironments().getApiEnv(), "qa");
    Assert.assertEquals(ekamConfig.getEnvironments().getDbEnv(), "qa");
    Assert.assertEquals(ekamConfig.getEnvironments().getWebEnv(), "qa");
    Assert.assertEquals(ekamConfig.getEnvironments().getDbEnv(), "qa");
  }

  @Test
  public void whenSpecificEnvsSetProvidedDefaultEnvShouldNotBeUsed() {
    System.setProperty("env", "");
    System.setProperty("api.env", "");
    System.setProperty("db.env", "");
    System.setProperty("config", "env");
    EkamConfig ekamConfig =
            com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(EkamConfig.class);
    Assert.assertEquals(ekamConfig.getEnvironments().getApiEnv(), "staging");
    Assert.assertEquals(ekamConfig.getEnvironments().getMobileEnv(), "qa");
    Assert.assertEquals(ekamConfig.getEnvironments().getWebEnv(), "qa");
    Assert.assertEquals(ekamConfig.getEnvironments().getDbEnv(), "dbstaging");
  }
}
