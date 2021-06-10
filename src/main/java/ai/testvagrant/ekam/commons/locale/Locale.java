package ai.testvagrant.ekam.commons.locale;

import ai.testvagrant.ekam.commons.io.GsonParser;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Map;

@Getter
@Setter
@SuppressWarnings({"rawtypes", "unchecked"})
public class Locale {

  private Map<String, LinkedTreeMap> localeDataSets;

  public Locale(File localeFile) {
    this.localeDataSets = new GsonParser().deserialize(localeFile.getAbsolutePath(), Map.class);
  }

  public <T> T getLocale(Class<T> tClass) {
    LinkedTreeMap map = localeDataSets.get(System.getProperty("locale"));
    return getMapAsObj(map, tClass);
  }

  private <T> T getMapAsObj(LinkedTreeMap map, Class<T> tClass) {
    Gson gson = new Gson();
    String objJson = gson.toJson(map);
    return gson.fromJson(objJson, tClass);
  }
}
