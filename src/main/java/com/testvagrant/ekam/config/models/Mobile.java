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

    @Override
    public String toString() {
        return "{"
                + "\"feed\":\"" + feed + "\""
                + ", \"target\":\"" + target + "\""
                + ", \"hub\":\"" + hub + "\""
                + "}";
    }
}
