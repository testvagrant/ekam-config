package com.testvagrant.ekam.config.models;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.config.utils.EkamPropertyReader;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mobile {
    private String feed = "";
    private String target = "android";
    private String hub = "";
    private String deviceFilters = "";
    private String serverArgs = "";
    private String executables = "";


    @Inject(optional = true)
    public void setFeed(@Named("mobile.feed") String feed) {
        this.feed = EkamPropertyReader.updateProperty("mobile.feed", feed);
    }

    @Inject(optional = true)
    public void setTarget(@Named("mobile.target") String target) {
        this.target = EkamPropertyReader.updateProperty("mobile.target", target);
    }

    @Inject(optional = true)
    public void setHub(@Named("mobile.hub") String hub) {
        this.hub = EkamPropertyReader.updateProperty("mobile.hub", hub);
    }

    @Inject(optional = true)
    public void setDeviceFilters(@Named("mobile.filters") String deviceFilters) {
        this.deviceFilters = EkamPropertyReader.updateProperty("mobile.filters", deviceFilters);
    }

    @Inject(optional = true)
    public void setServerArgs(@Named("mobile.server.args") String serverArgs) {
        this.serverArgs = EkamPropertyReader.updateProperty("mobile.server.args", deviceFilters);;
    }

    @Inject(optional = true)
    public void setExecutables(@Named("mobile.executables") String executables) {
        this.executables = EkamPropertyReader.updateProperty("mobile.executables", deviceFilters);;
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
                + "}";
    }
}
