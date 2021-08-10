package com.testvagrant.ekam.commons.cache.providers;

import com.testvagrant.ekam.commons.cache.LocaleCache;
import com.testvagrant.ekam.commons.constants.ResourcesConfigKeys;
import com.testvagrant.ekam.commons.io.FileFinder;
import com.testvagrant.ekam.commons.io.GsonParser;
import com.testvagrant.ekam.commons.io.ResourcePaths;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.testvagrant.ekam.commons.constants.ResourcesConfigKeys.Locale;

@SuppressWarnings({"rawtypes", "unchecked"})
public class LocaleProvider {

  private static LocaleCache cacheProvider;

  private LocaleProvider() {}

  public static LocaleCache localeProvider() {
    if (cacheProvider == null) {
      synchronized (LocaleProvider.class) {
        if (cacheProvider == null) {
          cacheProvider = new LocaleProvider().get();
        }
      }
    }
    return cacheProvider;
  }

  public LocaleCache load() {
    String env = System.getProperty(Locale.LOCALE_ENV, System.getProperty("env", ""));
    List<File> files = new ArrayList<>();
    //    Arrays.stream(ResourcePaths.RESOURCES).parallel().forEach(resource -> {
    //
    //    });
    String localeDir = ResourcePaths.getPath(ResourcePaths.ROOT, ResourcesConfigKeys.Locale.DIR);
    List<File> fileList = new FileFinder(localeDir, env).findWithExtension(".json");
    files.addAll(fileList);

    GsonParser gsonParser = new GsonParser();
    LocaleCache localeCache = new LocaleCache();

    files.forEach(
        file -> {
          try {
            String fileName = file.getName().replaceAll(".json", "").trim().toLowerCase();
            Map locales = gsonParser.deserialize(new FileReader(file), Map.class);
            locales.forEach(
                (locale, localeKeyValues) ->
                    localeCache.put(fileName, (String) locale, localeKeyValues));
          } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
          }
        });

    return localeCache;
  }

  private LocaleCache get() {
    return load();
  }
}
