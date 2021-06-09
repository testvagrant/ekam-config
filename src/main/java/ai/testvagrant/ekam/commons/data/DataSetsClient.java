package ai.testvagrant.ekam.commons.data;

import ai.testvagrant.ekam.commons.cache.DataSetsCache;
import ai.testvagrant.ekam.commons.exceptions.NoSuchKeyException;
import com.google.inject.Inject;

public class DataSetsClient extends DataSets {

  @Inject
  public DataSetsClient(DataSetsCache dataSetsCache) {
    super(dataSetsCache);
  }

  public <T> T getData(String key, Class<T> tClass) {
    try {
      return getValue(key, tClass, false);
    } catch (NoSuchKeyException e) {
      throw new RuntimeException(String.format("%s key not found", key));
    }
  }
}
