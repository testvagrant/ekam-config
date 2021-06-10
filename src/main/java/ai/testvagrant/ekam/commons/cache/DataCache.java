package ai.testvagrant.ekam.commons.cache;

import ai.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public abstract class DataCache<Value> {

  protected LoadingCache<String, Value> cache;

  protected LoadingCache<String, Value> build(
      CacheLoaderCondition<String, Value> cacheLoaderCondition) {
    return CacheBuilder.newBuilder()
        .maximumSize(100)
        .expireAfterWrite(4, TimeUnit.HOURS)
        .build(buildCacheLoader(cacheLoaderCondition));
  }

  public DataCache() {
    this.cache = build(cacheLoader());
  }

  public void put(String key, Value value) {
    throw new UnsupportedOperationException();
  }

  public Value get(String key) throws NoSuchKeyException {
    if (!isPresent(key)) throw new NoSuchKeyException(key);
    return cache.getIfPresent(key);
  }

  public synchronized boolean isPresent(Predicate<Value> predicate) {
    return anyMatch(cache, predicate);
  }

  public synchronized boolean isPresent(String key) {
    return anyMatch(cache, key);
  }

  public Value get(Predicate<Value> predicate) throws ExecutionException {
    throw new UnsupportedOperationException();
  }

  public long size() {
    return cache.size();
  }

  protected boolean anyMatch(LoadingCache<String, Value> cache, Predicate<Value> predicate) {
    return cache.asMap().values().stream().anyMatch(predicate);
  }

  protected boolean anyMatch(LoadingCache<String, Value> cache, String key) {
    return cache.asMap().containsKey(key);
  }

  protected CacheLoaderCondition<String, Value> cacheLoader() {
    return (key) -> cache.getIfPresent(key);
  }

  private CacheLoader<String, Value> buildCacheLoader(
      CacheLoaderCondition<String, Value> cacheLoaderCondition) {
    return new CacheLoader<String, Value>() {
      @Override
      public Value load(String key) {
        return cacheLoaderCondition.condition(key);
      }
    };
  }
}
