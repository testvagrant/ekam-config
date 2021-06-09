package ai.testvagrant.ekam.commons.locale;

import ai.testvagrant.ekam.commons.io.FileFinder;
import com.google.gson.Gson;
import com.google.inject.Provider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

public class LocaleClient implements Provider<LocaleClient> {

  public static <T> T findLocale(String fileName, Class<T> tClass) {
    String localePath =
        Objects.requireNonNull(LocaleClient.class.getClassLoader().getResource("locale")).getPath();
    return findFile(fileName, tClass, localePath);
  }

  public static <T> T findLocale(String path, String fileName, Class<T> tClass) {
    String localePath =
        Objects.requireNonNull(LocaleClient.class.getClassLoader().getResource("locale/" + path))
            .getPath();
    return findFile(fileName, tClass, localePath);
  }

  private static <T> T findFile(String fileName, Class<T> tClass, String localePath) {
    FileFinder fileFinder = new FileFinder(localePath);
    File file = fileFinder.find(fileName, ".json");
    try {
      Locale locale = new Gson().fromJson(new FileReader(file.getPath()), Locale.class);
      return locale.getLocale(tClass);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("Cannot find locale");
  }

  @Override
  public LocaleClient get() {
    return new LocaleClient();
  }
}
