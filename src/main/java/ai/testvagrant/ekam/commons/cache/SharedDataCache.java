package ai.testvagrant.ekam.commons.cache;

import ai.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.google.common.cache.LoadingCache;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class SharedDataCache<Value> extends DataCache<Value> {

  protected LoadingCache<String, Value> availableCache;
  protected LoadingCache<String, Value> engagedCache;

  public SharedDataCache() {
    availableCache = build(cacheLoader());
    engagedCache = build(cacheLoader());
  }

  public synchronized void put(String key, Value value) {
    cache.put(key, value);
    availableCache.put(key, value);
  }

  @Override
  public long size() {
    return availableCache.size();
  }

  @Override
  public Value get(String key) throws NoSuchKeyException {
    return get(key, false);
  }

  public synchronized Value get(String key, boolean lockRecord) throws NoSuchKeyException {
    if (!isPresent(key)) {
      throw new NoSuchKeyException(String.format("%s is not found, please add it first", key));
    }
    Value value = getValue(availableCache, key);
    if (Objects.isNull(value))
      throw new NoSuchKeyException(
          String.format("%s is a shared key and is engaged, please release to access it", key));
    if (lockRecord) lock(key);
    return value;
  }

  public synchronized void release(String key, Predicate<Map.Entry<String, Value>> predicate) {
    String finalKey = getFinalKey(engagedCache, key, predicate);
    Value value = getValue(engagedCache, finalKey);
    if (!finalKey.isEmpty()) {
      availableCache.put(finalKey, value);
      engagedCache.invalidate(finalKey);
    }
  }

  public synchronized void release(Predicate<Map.Entry<String, Value>> predicate) {
    String finalKey = getFinalKey(engagedCache, predicate);
    Value value = getValue(engagedCache, finalKey);
    if (!finalKey.isEmpty()) {
      availableCache.put(finalKey, value);
      engagedCache.invalidate(finalKey);
    }
  }

  public boolean isAvailable(String key) {
    return anyMatch(availableCache, key);
  }

  public boolean isEngaged(String key) {
    return anyMatch(engagedCache, key);
  }

  public synchronized void release(String key) {
    String finalKey = getFinalKey(engagedCache, key);
    Value value = getValue(engagedCache, finalKey);
    availableCache.put(finalKey, value);
    engagedCache.invalidate(finalKey);
  }

  protected <T> String getFinalKey(
      LoadingCache<String, Value> cache,
      String key,
      Predicate<Map.Entry<String, Value>> predicate) {
    boolean fullFledgedKey = cache.asMap().containsKey(key);
    if (!fullFledgedKey) {
      String finalKey = key;
      Optional<Map.Entry<String, Value>> finalEntry =
          cache.asMap().entrySet().stream()
              .filter(entry -> entry.getKey().startsWith(finalKey))
              .filter(predicate)
              .findFirst();
      if (finalEntry.isPresent()) {
        key = finalEntry.get().getKey();
      }
    }
    return key;
  }

  protected <T> String getFinalKey(
      LoadingCache<String, Value> cache, Predicate<Map.Entry<String, Value>> predicate) {
    String finalKey = "";
    Optional<Map.Entry<String, Value>> finalEntry =
        cache.asMap().entrySet().stream().filter(predicate).findFirst();
    if (finalEntry.isPresent()) {
      finalKey = finalEntry.get().getKey();
    }
    return finalKey;
  }

  protected String getFinalKey(LoadingCache<String, Value> cache, String key) {
    boolean fullFledgedKey = cache.asMap().containsKey(key);
    if (fullFledgedKey) {
      return key;
    } else {
      return cache.asMap().keySet().stream().filter(k -> k.startsWith(key)).findFirst().orElse(key);
    }
  }

  protected Value getValue(LoadingCache<String, Value> cache, String key) {
    String finalKey = getFinalKey(cache, key);
    return cache.getIfPresent(finalKey);
  }

  protected synchronized void lock(String key) {
    String finalKey = getFinalKey(availableCache, key);
    Value value = getValue(availableCache, finalKey);
    engagedCache.put(finalKey, value);
    availableCache.invalidate(finalKey);
  }

  @Override
  protected CacheLoaderCondition<String, Value> cacheLoader() {
    return (key) -> availableCache.getIfPresent(key);
  }
}
