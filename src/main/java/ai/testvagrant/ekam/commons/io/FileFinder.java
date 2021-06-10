package ai.testvagrant.ekam.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileFinder {

  private final String path;
  private boolean fileFound;
  private final List<File> allFiles;
  private File fileToSearch;
  private final List<File> matchingFiles;
  private final String env;

  public FileFinder() {
    this(System.getProperty("user.dir"));
  }

  public FileFinder(String path) {
    this.path = path;
    allFiles = new ArrayList<>();
    env = System.getProperty("env", "");
    matchingFiles = new ArrayList<>();
  }

  public List<File> find(String fileExtension) {
    collectFiles(new File(path), fileExtension);
    return allFiles;
  }

  public File find(String fileName, String fileExtension) {
    if (env.isEmpty()) {
      collectFile(new File(path), fileName, fileExtension);
    } else {
      collectFiles(new File(path), fileName, fileExtension);
      Optional<File> first =
          matchingFiles.stream().filter(file -> file.getPath().contains(env)).findFirst();
      fileToSearch = first.orElseThrow(() -> new RuntimeException("File not found"));
    }
    return fileToSearch;
  }

  private void collectFiles(File rootFile, String fileExtensionToSearch) {
    if (rootFile.exists() && rootFile.isDirectory()) {
      File[] files = rootFile.listFiles();
      assert files != null;
      for (File file : files) {
        if (!file.isDirectory()) {
          fileFound = file.getName().endsWith(fileExtensionToSearch);
          if (fileFound) {
            allFiles.add(file);
          }
        } else {
          collectFiles(file, fileExtensionToSearch);
        }
      }
    }
  }

  private void collectFile(File rootFile, String fileName, String fileExtensionToSearch) {
    if (rootFile.exists() && rootFile.isDirectory()) {
      File[] files = rootFile.listFiles();
      assert files != null;
      for (File file : files) {
        if (!file.isDirectory()) {
          fileFound = file.getName().equals(String.format("%s%s", fileName, fileExtensionToSearch));
          if (fileFound) {
            fileToSearch = file;
            break;
          }
        } else {
          collectFile(file, fileName, fileExtensionToSearch);
        }
      }
    }
  }

  private void collectFiles(File rootFile, String fileName, String fileExtensionToSearch) {
    if (rootFile.exists() && rootFile.isDirectory()) {
      File[] files = rootFile.listFiles();
      assert files != null;
      for (File file : files) {
        if (!file.isDirectory()) {
          fileFound = file.getName().equals(String.format("%s%s", fileName, fileExtensionToSearch));
          if (fileFound) {
            matchingFiles.add(file);
            break;
          }
        } else {
          collectFiles(file, fileName, fileExtensionToSearch);
        }
      }
    }
  }
}
