package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Getter
@Setter
public class LogConfig extends Config {

  private String level;
  private List<String> types;
  private String pattern;
  private String consoleLogPattern;
  private String fileLogPattern;
  private String maxFileSize;
  private String consoleLogLevel;
  private String fileLogLevel;
  private String logLevel;

  public LogConfig(Properties logProperties) {
    super(logProperties);
    this.types = Arrays.asList(setProperty(ConfigKeys.Log.LOG_TYPES, "console,file").split(","));
    this.pattern = setProperty(ConfigKeys.Log.LOG_PATTERN, "[%-5p] %d - %m%n");
    this.consoleLogPattern = setProperty(ConfigKeys.Log.CONSOLE_LOG_PATTERN, "");
    this.fileLogPattern = setProperty(ConfigKeys.Log.FILE_LOG_PATTERN, "");
    this.maxFileSize = setProperty(ConfigKeys.Log.LOG_FILE_MAX_SIZE, "100MB");
    this.logLevel = setProperty(ConfigKeys.Log.LOG_LEVEL, "debug");
    this.consoleLogLevel = setProperty(ConfigKeys.Log.CONSOLE_LOG_LEVEL, "");
    this.fileLogLevel = setProperty(ConfigKeys.Log.FILE_LOG_LEVEL, "");
  }

  @Override
  public String toString() {
    return "LogConfig{"
        + "level='"
        + level
        + '\''
        + ", types="
        + types
        + ", pattern='"
        + pattern
        + '\''
        + ", consoleLogPattern='"
        + consoleLogPattern
        + '\''
        + ", fileLogPattern='"
        + fileLogPattern
        + '\''
        + ", maxFileSize='"
        + maxFileSize
        + '\''
        + ", consoleLogLevel='"
        + consoleLogLevel
        + '\''
        + ", fileLogLevel='"
        + fileLogLevel
        + '\''
        + ", logLevel='"
        + logLevel
        + '\''
        + '}';
  }
}
