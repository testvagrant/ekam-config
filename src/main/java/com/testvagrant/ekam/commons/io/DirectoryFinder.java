package com.testvagrant.ekam.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectoryFinder {

  private boolean fileFound;
  private File fileToSearch;
  private String directoryName;
  List<String> directories;

  public DirectoryFinder() {
    this.directories = new ArrayList<>();
  }

  public Optional<String> find(String directoryName) {
    File rootFile = new File(System.getProperty("user.dir"));
    collectDirectories(rootFile, directoryName);
    return directories.stream()
        .filter(directoryPath -> directoryPath.toLowerCase().contains(directoryName))
        .findFirst();
  }

  private void collectDirectories(File rootFile, String directoryName) {
    if (rootFile.exists() && rootFile.isDirectory()) {
      File[] files = rootFile.listFiles();
      assert files != null;
      for (File file : files) {
        if (file.isDirectory() && file.getName().equalsIgnoreCase(directoryName)) {
          directories.add(file.getPath());
        } else {
          collectDirectories(file, directoryName);
        }
      }
    }
  }
}
