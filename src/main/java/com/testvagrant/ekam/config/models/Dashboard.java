package com.testvagrant.ekam.config.models;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.config.utils.EkamPropertyReader;
import lombok.Getter;

@Getter
public class Dashboard {
    private String dashboardUrl = "";

    @Inject(optional = true)
    public void setDashboardUrl(@Named("dashboard.url") String dashboardUrl) {
        this.dashboardUrl = EkamPropertyReader.updateProperty("dashboard.url", dashboardUrl);
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
