package com.testvagrant.ekam.commons.cache;

import com.google.common.cache.LoadingCache;

public class DataSetsCache<Value> extends SharedDataCache<Value> {

  protected boolean anyMatch(LoadingCache<String, Value> cache, String key) {
    boolean fullFledgedKey = cache.asMap().containsKey(key);
    if (fullFledgedKey) {
      return true;
    } else {
      return cache.asMap().keySet().stream().anyMatch(k -> k.startsWith(key));
    }
  }

  @Override
  protected CacheLoaderCondition<String, Value> cacheLoader() {
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
