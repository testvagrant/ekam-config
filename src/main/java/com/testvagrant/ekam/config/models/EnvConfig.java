package com.testvagrant.ekam.config.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import static com.testvagrant.ekam.config.models.ConfigKeys.Env.BASE_ENV;

@Getter @Setter
public class EnvConfig extends Config {
    private String env;
    private String webEnv;
    private String mobileEnv;
    private String apiEnv;
    private String dbEnv;
    private String dataSetsEnv;
    private String localeEnv;

    public EnvConfig(Properties properties) {
        super(properties);
        this.env = update(BASE_ENV, "");
        this.webEnv = update(ConfigKeys.Env.WEB_ENV, this.env);
        this.mobileEnv = update(ConfigKeys.Env.MOBILE_ENV, this.env);
        this.apiEnv = update(ConfigKeys.Env.API_ENV, this.env);
        this.dbEnv = update(ConfigKeys.Env.DB_ENV, this.env);
        this.dataSetsEnv = update(ConfigKeys.Env.DATASETS_ENV, this.env);
        this.localeEnv = update(ConfigKeys.Env.LOCALE_ENV, this.env);
    }

    @Override
    public String toString() {
        return "{"
                + "\"env\":\"" + env + "\""
                + ", \"webEnv\":\"" + webEnv + "\""
                + ", \"mobileEnv\":\"" + mobileEnv + "\""
                + ", \"apiEnv\":\"" + apiEnv + "\""
                + ", \"dbEnv\":\"" + dbEnv + "\""
                + ", \"dataSetsEnv\":\"" + dataSetsEnv + "\""
                + ", \"localeEnv\":\"" + localeEnv + "\""
                + "}";
    }
}
