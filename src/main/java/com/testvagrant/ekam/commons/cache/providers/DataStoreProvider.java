package com.testvagrant.ekam.commons.cache.providers;

import com.testvagrant.ekam.commons.cache.DataStoreCache;

public class DataStoreProvider {
  private static DataStoreCache<Object> injectorsCacheProvider;

  private DataStoreProvider() {}

  public static DataStoreCache<Object> dataStoreProvider() {
    if (injectorsCacheProvider == null) {
      synchronized (DataStoreProvider.class) {
        if (injectorsCacheProvider == null) {
          injectorsCacheProvider = new DataStoreProvider().get();
        }
      }
    }
    return injectorsCacheProvider;
  }

  private DataStoreCache<Object> get() {
    return new DataStoreCache<>();
  }
}
