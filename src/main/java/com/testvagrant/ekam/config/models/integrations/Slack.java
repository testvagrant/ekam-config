package com.testvagrant.ekam.config.models.integrations;

import com.testvagrant.ekam.config.models.Config;
import com.testvagrant.ekam.config.models.ConfigKeys;
import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter @Setter
public class Slack extends Config {
    private boolean notify;
    private boolean notifyMeEveryTime;

    public Slack(Properties properties) {
        super(properties);
        this.notify = update(ConfigKeys.Integrations.Slack.NOTIFY, false);
        this.notifyMeEveryTime = update(ConfigKeys.Integrations.Slack.NOTIFY_EVERYTIME, false);
    }

    @Override
    public String toString() {
        return "{"
                + "\"notify\":\"" + notify + "\""
                + ", \"notifyMeEveryTime\":\"" + notifyMeEveryTime + "\""
                + "}";
    }
}
