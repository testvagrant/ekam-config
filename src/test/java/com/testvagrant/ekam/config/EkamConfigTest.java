package com.testvagrant.ekam.config;

import com.google.inject.Inject;
import com.testvagrant.ekam.config.models.Ekam;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;


@Guice(modules = EkamConfigModule.class)
public class EkamConfigTest {

    @Inject
    Ekam ekam;

    @Test
    public void whenConfigIsNotSetEkamShouldReadFromDefaultDotPropertiesFile() {
        Assert.assertEquals(ekam.getEnv(), "qa");
        Assert.assertEquals(ekam.getMobile().getHub(), "browserstack");
    }

    @Test
    public void whenConfigIsSetEkamShouldReadFromConfigDotPropertiesFile() {
        System.setProperty("config", "remote");
        Ekam ekam = com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
        Assert.assertEquals(ekam.getEnv(), "staging");
        Assert.assertEquals(ekam.getMobile().getFeed(), "remoteTestFeed");
    }

    @Test
    public void whenConfigIsSetEkamShouldAutoFillDefaultProperties() {
        Assert.assertEquals(ekam.getMobile().getFeed(), "mobileTestFeed");
        Assert.assertEquals(ekam.getWeb().getFeed(), "webTestFeed");
        System.setProperty("config", "remote");
        Ekam ekam = com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
        Assert.assertEquals(ekam.getMobile().getFeed(), "remoteTestFeed");
        Assert.assertEquals(ekam.getWeb().getFeed(), "webTestFeed");
    }

    @Test
    public void whenConfigValueIsNotDefinedInPropertiesFileDefaultValueShouldBeLoaded() {
        System.setProperty("config", "remote");
        Ekam ekam = com.google.inject.Guice.createInjector(new EkamConfigModule()).getInstance(Ekam.class);
        Assert.assertTrue(ekam.getIntegrations().getSlack().isNotify());
        Assert.assertFalse(ekam.getIntegrations().getSlack().isNotifyMeEveryTime());
    }

    @Test
    public void whenTheConfigFolderDoesntExistEkamShouldLoadDefaultConfiguration() {
        Ekam ekam = com.google.inject.Guice.createInjector(new EkamConfigModule("invalid")).getInstance(Ekam.class);
        Assert.assertEquals(ekam.getEnv(), "");

        Assert.assertEquals(ekam.getMobile().getHub(), "browserstack");
        Assert.assertEquals(ekam.getMobile().getFeed(), "");
        Assert.assertEquals(ekam.getMobile().getTarget(), "android");

        Assert.assertEquals(ekam.getWeb().getFeed(), "");
        Assert.assertEquals(ekam.getWeb().getTarget(), "chrome");
        Assert.assertEquals(ekam.getWeb().getHub(), "browserstack");

        Assert.assertEquals(ekam.getDashboard().getDashboardUrl(), "");

        Assert.assertFalse(ekam.getIntegrations().getSlack().isNotify());
        Assert.assertFalse(ekam.getIntegrations().getSlack().isNotifyMeEveryTime());

    }
}
