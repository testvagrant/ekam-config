package com.testvagrant.ekam.config.models.integrations;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.config.utils.EkamPropertyReader;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Slack {
    private boolean notify;
    private boolean notifyMeEveryTime;

    @Inject(optional = true)
    public void setNotify(@Named("slack.notify") boolean notify) {
        this.notify = EkamPropertyReader.updateProperty("slack.notify",notify);
    }

    @Inject(optional = true)
    public void setNotifyMeEveryTime(@Named("slack.notify.everytime") boolean notifyMeEveryTime) {
        this.notifyMeEveryTime = EkamPropertyReader.updateProperty("slack.notify.everytime",notifyMeEveryTime);
    }

    @Override
    public String toString() {
        return "{"
                + "\"notify\":\"" + notify + "\""
                + ", \"notifyMeEveryTime\":\"" + notifyMeEveryTime + "\""
                + "}}";
    }
}
