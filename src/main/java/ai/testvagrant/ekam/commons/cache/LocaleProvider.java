package ai.testvagrant.ekam.commons.cache;

import ai.testvagrant.ekam.commons.io.FileFinder;
import ai.testvagrant.ekam.commons.io.GsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.google.inject.Provider;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"rawtypes", "unchecked"})
public class LocaleProvider implements Provider<LocaleCache> {

  public LocaleCache load() {
    String dataSetsRootPath =
        Objects.requireNonNull(this.getClass().getClassLoader().getResource("locale"))
            .getPath();
    ;
    List<File> files = new FileFinder(dataSetsRootPath).find(".json");
    LocaleCache localeCache = new LocaleCache();
    files.forEach(
        file -> {
          try {
            Map<String, LinkedTreeMap> fileContents =
                new GsonParser().deserialize(new FileReader(file), Map.class);
            fileContents.forEach(
                (key, value) -> {
                  localeCache.put(file.getName().replaceAll(".json","").trim().toLowerCase(), key, value);
                });
          } catch (Exception e) {
          }
        });
    return localeCache;
  }

  @Override
  public LocaleCache get() {
    return load();
  }
}
