package com.testvagrant.ekam.config;

import com.testvagrant.ekam.config.models.Ekam;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EkamConfigTest {

  @Test
  public void whenConfigIsNotSetEkamShouldReadFromDefaultDotPropertiesFile() {
    Ekam ekam =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
    Assert.assertEquals(ekam.getEnv(), "qa");
    Assert.assertEquals(ekam.getMobile().getHub(), "");
  }

  @Test
  public void whenConfigIsSetEkamShouldReadFromConfigDotPropertiesFile() {
    System.setProperty("config", "remote");
    System.setProperty("env", "");
    System.setProperty("mobile.feed", "");
    Ekam ekam =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
    Assert.assertEquals(ekam.getEnv(), "staging");
    Assert.assertEquals(ekam.getMobile().getFeed(), "remoteTestFeed");
  }

  @Test
  public void whenConfigValueIsNotDefinedInPropertiesFileDefaultValueShouldBeLoaded() {
    System.setProperty("config", "remote");
    Ekam ekam =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
    Assert.assertTrue(ekam.getIntegrations().getSlack().isNotify());
    Assert.assertFalse(ekam.getIntegrations().getSlack().isNotifyMeEveryTime());
  }

  @Test
  public void whenSpecificEnvsAreNotProvidedDefaultEnvShouldBeUsed() {
    System.setProperty("env", "");
    Ekam ekam =
        com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
    Assert.assertEquals(ekam.getEnvironments().getApiEnv(), "qa");
    Assert.assertEquals(ekam.getEnvironments().getDbEnv(), "qa");
    Assert.assertEquals(ekam.getEnvironments().getWebEnv(), "qa");
    Assert.assertEquals(ekam.getEnvironments().getDbEnv(), "qa");
  }

  @Test
  public void whenSpecificEnvsSetProvidedDefaultEnvShouldNotBeUsed() {
    System.setProperty("env", "");
    System.setProperty("api.env", "");
    System.setProperty("db.env", "");
    System.setProperty("config", "env");
    Ekam ekam =
            com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
    Assert.assertEquals(ekam.getEnvironments().getApiEnv(), "staging");
    Assert.assertEquals(ekam.getEnvironments().getMobileEnv(), "qa");
    Assert.assertEquals(ekam.getEnvironments().getWebEnv(), "qa");
    Assert.assertEquals(ekam.getEnvironments().getDbEnv(), "dbstaging");
  }
}
