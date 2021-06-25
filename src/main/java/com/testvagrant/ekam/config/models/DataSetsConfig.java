package com.testvagrant.ekam.config.models;

import java.util.Properties;

public class DataSetsConfig extends Config {
    private String dir;
    public DataSetsConfig(Properties properties) {
        super(properties);
        this.dir = update(ConfigKeys.DATASETS.DIR, "data_sets");
    }

    @Override
    public String toString() {
        return "{"
                + "\"dir\":\"" + dir + "\""
                + "}";
    }
}
