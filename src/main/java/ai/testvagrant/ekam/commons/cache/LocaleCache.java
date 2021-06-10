package ai.testvagrant.ekam.commons.cache;

import ai.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import ai.testvagrant.ekam.commons.io.GsonParser;
import com.google.gson.internal.LinkedTreeMap;

@SuppressWarnings("rawtypes")
public class LocaleCache extends DataCache<LinkedTreeMap> {

  public void put(String fileName, String locale, LinkedTreeMap linkedTreeMap) {
    String finalKey = getLocaleKey(fileName, locale);
    cache.put(finalKey, linkedTreeMap);
  }

  public <V> V get(String key, Class<V> vClass) throws NoSuchKeyException {
    String localeKey = getLocaleKey(key);
    LinkedTreeMap map = super.get(localeKey);
    return new GsonParser().deserialize(map, vClass);
  }

  @Override
  protected CacheLoaderCondition<String, LinkedTreeMap> cacheLoader() {
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
    String locale = System.getProperty("locale", "");
    return getLocaleKey(fileName, locale);
  }

  private String getLocaleKey(String fileName, String locale) {
    return String.format("%s_%s", fileName, locale);
  }
}
