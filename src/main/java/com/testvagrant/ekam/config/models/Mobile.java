package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import static com.testvagrant.ekam.config.properties.ConfigPropertyReader.*;

@Getter @Setter
public class Mobile extends Config {
    private String feed;
    private String target;
    private String hub;
    private String deviceFilters;
    private String serverArgs;
    private String executables;
    private boolean uploadApp;


    public Mobile(Properties mobileProperties) {
        super(mobileProperties);
        this.feed = update(Keys.Mobile.FEED, "");
        this.target = update(Keys.Mobile.TARGET, "android");
        this.hub = update(Keys.Mobile.HUB, "");
        this.deviceFilters = update(Keys.Mobile.FILTERS, "");
        this.serverArgs = update(Keys.Mobile.SERVER_ARGS, "");
        this.executables = update(Keys.Mobile.EXECUTABLES, "");
        this.uploadApp = update(Keys.Mobile.REMOTE_UPLOAD_APP, false);
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
                + "\"feed\":\"" + feed + "\""
                + ", \"target\":\"" + target + "\""
                + ", \"hub\":\"" + hub + "\""
                + ", \"deviceFilters\":\"" + deviceFilters + "\""
                + ", \"serverArgs\":\"" + serverArgs + "\""
                + ", \"executables\":\"" + executables + "\""
                + ", \"uploadApp\":\"" + uploadApp +"\""
                + "}";
    }
}
