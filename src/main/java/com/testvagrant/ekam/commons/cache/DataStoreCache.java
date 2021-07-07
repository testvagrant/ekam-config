package com.testvagrant.ekam.commons.cache;

import java.util.Optional;

public class DataStoreCache<Value> extends DataCache<Value> {

  private final DataCache<Value> dataCache;

  public DataStoreCache() {
    dataCache = new DataCache<>();
  }

  public void put(String key, Value value) {
    dataCache.put(key, value);
  }

  public Optional<Value> get(String key) {
    return dataCache.get(key);
  }
}
