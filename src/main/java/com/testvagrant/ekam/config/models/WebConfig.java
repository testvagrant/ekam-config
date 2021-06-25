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
  private boolean launchSite;

  public WebConfig(Properties webProperties) {
    super(webProperties);
    this.feed = update(ConfigKeys.Web.FEED, "");
    this.target = update(ConfigKeys.Web.TARGET, "chrome");
    this.headless = update(ConfigKeys.Web.HEADLESS, false);
    this.launchSite = update(ConfigKeys.Web.LAUNCHSITE, false);
    this.hub = update(ConfigKeys.Web.HUB, "");
  }

  public boolean isAny() {
    return this.target.equalsIgnoreCase("any");
  }

  public boolean isRemote() {
    return !this.hub.isEmpty();
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
        + launchSite
        + "\""
        + "}";
  }
}