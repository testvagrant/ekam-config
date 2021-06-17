package com.testvagrant.ekam.config.models;

import com.google.inject.Inject;
import com.testvagrant.ekam.config.models.integrations.Jira;
import com.testvagrant.ekam.config.models.integrations.Slack;
import com.testvagrant.ekam.config.utils.EkamPropertyReader;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Integrations {

    @Inject(optional = true)
    private Slack slack;

    @Inject(optional = true)
    private Jira jira;


    @Inject(optional = true)
    public void setSlack(Slack slack) {
        this.slack = EkamPropertyReader.createInstance(slack, Slack.class);
    }

    @Inject(optional = true)
    public void setJira(Jira jira) {
        this.jira = EkamPropertyReader.createInstance(jira, Jira.class);;
    }

    @Override
    public String toString() {
        return "{"
                + "\"slack\":" + slack
                + ", \"jira\":" + jira
                + "}";
    }
}
