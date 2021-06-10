package ai.testvagrant.ekam.commons.tests;

import ai.testvagrant.ekam.commons.cache.LocaleCache;
import ai.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import ai.testvagrant.ekam.commons.modules.LocaleModule;
import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = LocaleModule.class)
public class LocaleCacheTest {

  @Inject private LocaleCache localeCache;

  @Test
  public void locateEn() throws NoSuchKeyException {
    System.setProperty("locale", "en");
    Locale sample_locales = localeCache.get("sample_locales", Locale.class);
    Assert.assertEquals(sample_locales.locale, "English");
  }

  @Test
  public void locateFr() throws NoSuchKeyException {
    System.setProperty("locale", "fr");
    Locale sample_locales = localeCache.get("sample_locales", Locale.class);
    Assert.assertEquals(sample_locales.locale, "French");
  }

  @Getter
  @Setter
  private static class Locale {
    private String locale;
  }
}
