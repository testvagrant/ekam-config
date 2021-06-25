package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter @Setter
public class Env extends Config {
    private String webEnv;
    private String mobileEnv;
    private String apiEnv;
    private String dbEnv;

    public Env(Properties properties, String defaultEnv) {
        super(properties);
        this.webEnv = update(ConfigKeys.Env.WEB_ENV, defaultEnv);
        this.mobileEnv = update(ConfigKeys.Env.MOBILE_ENV, defaultEnv);
        this.apiEnv = update(ConfigKeys.Env.API_ENV, defaultEnv);
        this.dbEnv = update(ConfigKeys.Env.DB_ENV, defaultEnv);
    }
}
