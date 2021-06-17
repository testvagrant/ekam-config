package com.testvagrant.ekam.config.models;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.config.utils.EkamPropertyReader;
import lombok.Getter;


@Getter
public class Web {
    private String feed = "";
    private String target = "chrome";
    private boolean headless = false;
    private String hub = "browserstack";

    @Inject(optional = true)
    public void setFeed(@Named("web.feed") String feed) {
        this.feed = EkamPropertyReader.updateProperty("web.feed", feed);
    }

    @Inject(optional = true)
    public void setTarget(@Named("web.target") String target) {
        this.target = EkamPropertyReader.updateProperty("web.target", target);
    }

    @Inject(optional = true)
    public void setHeadless(@Named("web.headless") boolean headless) {
        this.headless = EkamPropertyReader.updateProperty("web.headless", headless);
    }

    @Inject(optional = true)
    public void setHub(@Named("web.hub") String hub) {
        this.hub = EkamPropertyReader.updateProperty("web.hub", hub);
    }

    @Override
    public String toString() {
        return "{"
                + "\"feed\":\"" + feed + "\""
                + ", \"target\":\"" + target + "\""
                + ", \"headless\":\"" + headless + "\""
                + ", \"hub\":\"" + hub + "\""
                + "}";
    }
}