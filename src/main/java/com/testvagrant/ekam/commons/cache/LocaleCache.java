package com.testvagrant.ekam.commons.cache;

import com.testvagrant.ekam.commons.io.GsonParser;

import static com.testvagrant.ekam.commons.constants.ResourcesConfigKeys.Locale;

public class LocaleCache<Value> extends DataCache<Value> {

  public void put(String fileName, String locale, Value linkedTreeMap) {
    String finalKey = getLocaleKey(fileName, locale);
    cache.put(finalKey, linkedTreeMap);
  }

  public <V> V get(String key, Class<V> vClass) {
    String localeKey = getLocaleKey(key);
    Value map =
        super.get(localeKey)
            .orElseThrow(() -> new RuntimeException(String.format("key '%s' not found", key)));
    return new GsonParser().deserialize(map, vClass);
  }

  @Override
  protected CacheLoaderCondition<String, Value> cacheLoader() {
    return (key) -> {
      String finalKey =
          cache.asMap().keySet().stream()
              .filter(k -> k.equalsIgnoreCase(getLocaleKey(key)))
              .findFirst()
              .orElse(key);
      return cache.getIfPresent(finalKey);
    };
  }

  private String getLocaleKey(String fileName) {
    String locale = System.getProperty(Locale.LOCALE, "en");
    return getLocaleKey(fileName, locale);
  }

  private String getLocaleKey(String fileName, String locale) {
    return String.format("%s_%s", fileName, locale);
  }
}
