package com.testvagrant.ekam.config.models;

public class ConfigKeys {
  public static class Ekam {
    public static final String ENV = "env";
    public static final String LOCALE = "locale";
  }

  public static class Mobile {
    public static final String FEED = "mobile.feed";
    public static final String TARGET = "mobile.target";
    public static final String HUB = "mobile.hub";
    public static final String FILTERS = "mobile.filters";
    public static final String SERVER_ARGS = "mobile.server.args";
    public static final String EXECUTABLES = "mobile.executables";
    public static final String REMOTE_UPLOAD_APP = "mobile.remote.uploadapp";
  }

  public static class Web {
    public static final String FEED = "web.feed";
    public static final String TARGET = "web.target";
    public static final String HUB = "web.hub";
    public static final String HEADLESS = "web.headless";
    public static final String LAUNCHSITE = "web.launchsite";
  }

  public static class Integrations {
    public static class Slack {
      public static final String NOTIFY = "slack.notify";
      public static final String NOTIFY_EVERYTIME = "slack.notify.everytime";
    }

    public static class JIRA {}
  }

  public static class DASHBOARD {
    public static final String URL = "dashboard.url";
  }
}
