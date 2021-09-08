package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class WebConfig extends Config {
  private String feed;
  private String target;
  private boolean headless;
  private String hub;
  private String launchUrl;
  private boolean logConsoleErrors;

  public WebConfig(Properties webProperties) {
    super(webProperties);
    this.feed = setProperty(ConfigKeys.Web.FEED, "");
    this.target = setProperty(ConfigKeys.Web.TARGET, "chrome");
    this.headless = setProperty(ConfigKeys.Web.HEADLESS, false);
    this.launchUrl = setProperty(ConfigKeys.Web.URL, "");
    this.hub = setProperty(ConfigKeys.Web.HUB, "");
    this.logConsoleErrors = setProperty(ConfigKeys.Web.LOG_CONSOLE, false);
  }

  public boolean isAny() {
    return this.target.equalsIgnoreCase("any");
  }

  public boolean isRemote() {
    return !this.hub.isEmpty();
  }

  public boolean launchSite() {
    return !launchUrl.isEmpty();
  }

  @Override
  public String toString() {
    return "{"
        + "\"feed\":\""
        + feed
        + "\""
        + ", \"target\":\""
        + target
        + "\""
        + ", \"headless\":\""
        + headless
        + "\""
        + ", \"hub\":\""
        + hub
        + "\""
        + ", \"launchSite\":\""
        + launchUrl
        + "\""
        + "}";
  }
}
