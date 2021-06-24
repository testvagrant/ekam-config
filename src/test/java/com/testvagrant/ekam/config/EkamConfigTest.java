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
    System.setProperty("env","");
    System.setProperty("mobile.feed","");
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
}
