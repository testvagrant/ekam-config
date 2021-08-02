package com.testvagrant.ekam.config;

import com.testvagrant.ekam.config.models.EkamConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.ClearSystemProperty;
import org.junitpioneer.jupiter.SetSystemProperty;

public class EkamConfigTest {

    @Test
    @ClearSystemProperty(key = "config")
    public void whenConfigIsNotSetEkamShouldReadFromDefaultDotPropertiesFile() {
        EkamConfig ekamConfig =
                com.google.inject.Guice.createInjector(new EkamConfigModule())
                        .getInstance(EkamConfig.class);
        Assertions.assertEquals(ekamConfig.getEnvironments().getEnv(), "qa");
        Assertions.assertEquals(ekamConfig.getMobile().getHub(), "");
    }

    @Test
    @SetSystemProperty(key = "config", value = "remote")
    @SetSystemProperty(key = "env", value = "")
    @SetSystemProperty(key = "mobile.feed", value = "")
    public void whenConfigIsSetEkamShouldReadFromConfigDotPropertiesFile() {
        EkamConfig ekamConfig =
                com.google.inject.Guice.createInjector(new EkamConfigModule())
                        .getInstance(EkamConfig.class);
        Assertions.assertEquals(ekamConfig.getEnvironments().getEnv(), "staging");
        Assertions.assertEquals(ekamConfig.getMobile().getFeed(), "remoteTestFeed");
    }

    @Test
    @SetSystemProperty(key = "config", value = "remote")
    public void whenConfigValueIsNotDefinedInPropertiesFileDefaultValueShouldBeLoaded() {
        EkamConfig ekamConfig =
                com.google.inject.Guice.createInjector(new EkamConfigModule())
                        .getInstance(EkamConfig.class);
        Assertions.assertTrue(ekamConfig.getIntegrations().getSlack().isNotify());
        Assertions.assertFalse(ekamConfig.getIntegrations().getSlack().isNotifyMeEveryTime());
    }

    @Test
    @SetSystemProperty(key = "env", value = "")
    public void whenSpecificEnvsAreNotProvidedDefaultEnvShouldBeUsed() {
        EkamConfig ekamConfig =
                com.google.inject.Guice.createInjector(new EkamConfigModule())
                        .getInstance(EkamConfig.class);
        Assertions.assertEquals(ekamConfig.getEnvironments().getApiEnv(), "qa");
        Assertions.assertEquals(ekamConfig.getEnvironments().getDbEnv(), "qa");
        Assertions.assertEquals(ekamConfig.getEnvironments().getWebEnv(), "qa");
        Assertions.assertEquals(ekamConfig.getEnvironments().getDbEnv(), "qa");
    }

    @Test
    @SetSystemProperty(key = "db.env", value = "")
    @SetSystemProperty(key = "api.env", value = "")
    @SetSystemProperty(key = "env", value = "")
    @SetSystemProperty(key = "config", value = "env")
    public void whenSpecificEnvsSetProvidedDefaultEnvShouldNotBeUsed() {
        EkamConfig ekamConfig =
                com.google.inject.Guice.createInjector(new EkamConfigModule())
                        .getInstance(EkamConfig.class);
        Assertions.assertEquals(ekamConfig.getEnvironments().getApiEnv(), "staging");
        Assertions.assertEquals(ekamConfig.getEnvironments().getMobileEnv(), "qa");
        Assertions.assertEquals(ekamConfig.getEnvironments().getWebEnv(), "qa");
        Assertions.assertEquals(ekamConfig.getEnvironments().getDbEnv(), "dbstaging");
    }
}
