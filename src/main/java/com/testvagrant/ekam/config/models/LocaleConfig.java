package com.testvagrant.ekam.config.models;

import java.util.Properties;

import static com.testvagrant.ekam.config.models.ConfigKeys.Locale.LOCALE;
import static com.testvagrant.ekam.config.models.ConfigKeys.Locale.LOCALE_DIR;


public class LocaleConfig extends Config {
    private String dir;
    private String locale;
    public LocaleConfig(Properties properties) {
        super(properties);
        this.locale = update(LOCALE, "en");
        this.dir = update(LOCALE_DIR, "locale");
    }

    @Override
    public String toString() {
        return "{"
                + "\"dir\":\"" + dir + "\""
                + ", \"locale\":\"" + locale + "\""
                + "}";
    }
}
