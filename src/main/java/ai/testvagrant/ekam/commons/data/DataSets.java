package ai.testvagrant.ekam.commons.data;

import ai.testvagrant.ekam.commons.cache.DataSetsCache;
import ai.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import ai.testvagrant.ekam.commons.io.GsonParser;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.inject.Inject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class DataSets {

  private final DataSetsCache dataSetsCache;

  @Inject
  public DataSets(DataSetsCache dataSetsCache) {
    this.dataSetsCache = dataSetsCache;
  }

  public <T> T getValue(String key, Class<T> tClass) throws NoSuchKeyException {
    return getValue(key, tClass, false);
  }

  public <T> T getValue(String key, Class<T> tClass, boolean lock) throws NoSuchKeyException {
    String value = getJsonString(key, lock);
    return deserialize(value, tClass);
  }

  public <T> T findFirst(List<T> dataList) {
    if (dataList.isEmpty()) return null;
    return dataList.stream().findFirst().orElse(null);
  }

  public <T> T findAny(List<T> dataList) {
    if (dataList.isEmpty()) return null;
    return dataList.stream().findAny().orElse(null);
  }

  public <T> List<T> findByPredicate(List<T> dataList, Predicate predicate) {
    if (dataList.isEmpty()) return null;
    return (List<T>) dataList.stream().filter(predicate).collect(Collectors.toList());
  }

  public void release(String key, Predicate<Map.Entry<String, LinkedTreeMap>> entryPredicate) {
    dataSetsCache.release(key, entryPredicate);
  }

  public void release(Predicate<Map.Entry<String, LinkedTreeMap>> entryPredicate) {
    dataSetsCache.release(entryPredicate);
  }

  private <T> String getJsonString(T type) {
    return new GsonParser().serialize(type);
  }

  private <T> String getJsonString(String key) throws NoSuchKeyException {
    return getJsonString(key, false);
  }

  private <T> String getJsonString(String key, boolean lock) throws NoSuchKeyException {
    T type = (T) dataSetsCache.get(key.toLowerCase(), lock);
    return new GsonParser().serialize(type);
  }

  private <T> T deserialize(String value, Class<T> tClass) {
    return new GsonParser().deserialize(value, tClass);
  }

  private Object deserialize(String value, Type type) {
    return new Gson().fromJson(value, type); // TODO : Move this to json parser
  }
}
