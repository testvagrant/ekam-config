package ai.testvagrant.ekam.commons.cache;

import com.google.common.cache.LoadingCache;
import com.google.gson.internal.LinkedTreeMap;

@SuppressWarnings("rawtypes")
public class DataSetsCache extends SharedDataCache<LinkedTreeMap> {

  protected boolean anyMatch(LoadingCache<String, LinkedTreeMap> cache, String key) {
    boolean fullFledgedKey = cache.asMap().containsKey(key);
    if (fullFledgedKey) {
      return true;
    } else {
      return cache.asMap().keySet().stream().anyMatch(k -> k.startsWith(key));
    }
  }

  @Override
  protected CacheLoaderCondition<String, LinkedTreeMap> cacheLoader() {
    return (key) -> {
      String finalKey =
          availableCache.asMap().keySet().stream()
              .filter(k -> k.startsWith(key))
              .findFirst()
              .orElse(key);
      return availableCache.getIfPresent(finalKey);
    };
  }
}
