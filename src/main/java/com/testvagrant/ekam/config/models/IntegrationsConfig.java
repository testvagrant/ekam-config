package com.testvagrant.ekam.config.models;

import com.google.inject.Inject;
import com.testvagrant.ekam.config.models.integrations.Jira;
import com.testvagrant.ekam.config.models.integrations.Slack;
import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class IntegrationsConfig extends Config {

    @Inject(optional = true)
    private Slack slack;

    @Inject(optional = true)
    private Jira jira;

    public IntegrationsConfig(Properties properties) {
        super(properties);
        this.slack = new Slack(properties);
        this.jira = new Jira(properties);
    }

    @Override
    public String toString() {
        return "{" + "\"slack\":" + slack + ", \"jira\":" + jira + "}";
    }
}
