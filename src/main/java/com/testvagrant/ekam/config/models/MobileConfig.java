package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class MobileConfig extends Config {
    private String feed;
    private String target;
    private String hub;
    private String deviceFilters;
    private String serverArgs;
    private String executables;
    private boolean uploadApp;

    public MobileConfig(Properties mobileProperties) {
        super(mobileProperties);
        this.feed = setProperty(ConfigKeys.Mobile.FEED, "");
        this.target = setProperty(ConfigKeys.Mobile.TARGET, "android");
        this.hub = setProperty(ConfigKeys.Mobile.HUB, "");
        this.deviceFilters = setProperty(ConfigKeys.Mobile.FILTERS, "");
        this.serverArgs = setProperty(ConfigKeys.Mobile.SERVER_ARGS, "");
        this.executables = setProperty(ConfigKeys.Mobile.EXECUTABLES, "");
        this.uploadApp = setProperty(ConfigKeys.Mobile.REMOTE_UPLOAD_APP, false);
        setProperty(ConfigKeys.Mobile.MOBILE_APP_NAME, "");
    }

    public boolean isAny() {
        return this.target.equalsIgnoreCase("any");
    }

    public boolean isRemote() {
        return !this.hub.isEmpty();
    }

    public boolean isServerArgsProvided() {
        return !this.serverArgs.isEmpty();
    }

    public boolean isDeviceFiltersProvided() {
        return !this.deviceFilters.isEmpty();
    }

    public boolean isExecutablesProvided() {
        return !this.executables.isEmpty();
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
                + ", \"hub\":\""
                + hub
                + "\""
                + ", \"deviceFilters\":\""
                + deviceFilters
                + "\""
                + ", \"serverArgs\":\""
                + serverArgs
                + "\""
                + ", \"executables\":\""
                + executables
                + "\""
                + ", \"uploadApp\":\""
                + uploadApp
                + "\""
                + "}";
    }
}
