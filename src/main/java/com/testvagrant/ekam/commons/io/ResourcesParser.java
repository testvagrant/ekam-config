package com.testvagrant.ekam.commons.io;

import java.io.File;
import java.lang.reflect.Type;

public class ResourcesParser {
  public <T> T getResource(String filePath, String extension, Class<T> tClass) {
    File file = getFile(filePath, extension);
    return new GsonParser().deserialize(file.getPath(), tClass);
  }

  public <T> T getResource(String filePath, String extension, Type tType) {
    File file = getFile(filePath, extension);
    return new GsonParser().deserialize(file.getPath(), tType);
  }

  private File getFile(String filePath, String extension) {
    return new FileFinder(ResourcePaths.TEST_RESOURCES).find(filePath, extension);
  }
}
