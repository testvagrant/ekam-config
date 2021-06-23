package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import static com.testvagrant.ekam.config.properties.ConfigPropertyReader.update;

@Getter
@Setter
public class Web extends Config {
  private String feed;
  private String target;
  private boolean headless;
  private String hub;
  private boolean launchSite;

  public Web(Properties webProperties) {
    super(webProperties);
    this.feed = update(Keys.Web.FEED, "");
    this.target = update(Keys.Web.TARGET, "chrome");
    this.headless = update(Keys.Web.HEADLESS, false);
    this.launchSite = update(Keys.Web.LAUNCHSITE, false);
    this.hub = update(Keys.Web.HUB, "");
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
