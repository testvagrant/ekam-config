package com.testvagrant.ekam.config.models;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.config.utils.EkamPropertyReader;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Ekam {
    private String env = "";

    private Mobile mobile;

    private Web web;

    private Integrations integrations;

    private Dashboard dashboard;

    @Inject(optional = true)
    public void setEnv(@Named("env") String env) {
        this.env = EkamPropertyReader.updateProperty("env", env);
    }

    @Inject(optional = true)
    public void setMobile(Mobile mobile) {
        this.mobile = EkamPropertyReader.createInstance(mobile, Mobile.class);
    }

    @Inject(optional = true)
    public void setWeb(Web web) {
        this.web = EkamPropertyReader.createInstance(web, Web.class);
    }

    @Inject(optional = true)
    public void setIntegrations(Integrations integrations) {
        this.integrations = EkamPropertyReader.createInstance(integrations, Integrations.class);;
    }

    @Inject(optional = true)
    public void setDashboard(Dashboard dashboard) {
        this.dashboard = EkamPropertyReader.createInstance(dashboard, Dashboard.class);;
    }

    @Override
    public String toString() {
        return "{"
                + "\"env\":\"" + env + "\""
                + ", \"mobile\":" + mobile
                + ", \"web\":" + web
                + ", \"integrations\":" + integrations
                + ", \"dashboard\":" + dashboard
                + "}";
    }
}
