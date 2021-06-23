package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import static com.testvagrant.ekam.config.properties.ConfigPropertyReader.update;

@Getter @Setter
public class Dashboard extends Config {
    private String dashboardUrl = "";

    public Dashboard(Properties properties) {
        super(properties);
        this.dashboardUrl = update(Keys.DASHBOARD.URL, "");
    }

    public boolean publishToDashboard() {
        return dashboardUrl.isEmpty();
    }

    @Override
    public String toString() {
        return "{"
                + "\"dashboardUrl\":\"" + dashboardUrl + "\""
                + "}";
    }
}
