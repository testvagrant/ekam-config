package com.testvagrant.ekam.config.models;

public class ConfigKeys {

    public static class Locale {
        public static final String LOCALE = "locale";
        public static final String DIR = "locale.dir";
    }

    public static class Mobile {
        public static final String FEED = "mobile.feed";
        public static final String TARGET = "mobile.target";
        public static final String HUB = "mobile.hub";
        public static final String FILTERS = "mobile.filters";
        public static final String SERVER_ARGS = "mobile.server.args";
        public static final String EXECUTABLES = "mobile.executables";
        public static final String REMOTE_UPLOAD_APP = "mobile.remote.uploadapp";
        public static final String MOBILE_APP_NAME = "mobile.app.name";
    }

    public static class Web {
        public static final String FEED = "web.feed";
        public static final String TARGET = "web.target";
        public static final String HUB = "web.hub";
        public static final String HEADLESS = "web.headless";
        public static final String URL = "web.url";
    }

    public static class Api {
        public static final String HOSTS = "api.hosts";
    }

    public static class DB {
        public static final String DRIVERS = "db.drivers";
    }

    public static class DATASETS {
        public static final String DIR = "datasets.dir";
    }

    public static class Cloud {
        public static final String DIR = "cloud.config.dir";
    }

    public static class Integrations {
        public static class Slack {
            public static final String NOTIFY = "slack.notify";
            public static final String NOTIFY_EVERYTIME = "slack.notify.everytime";
        }

        public static class JIRA {
        }
    }

    public static class DASHBOARD {
        public static final String URL = "dashboard.url";
    }

    public static class Env {
        public static final String BASE_ENV = "env";
        public static final String API_ENV = "api.env";
        public static final String WEB_ENV = "web.env";
        public static final String MOBILE_ENV = "mobile.env";
        public static final String DB_ENV = "db.env";
        public static final String LOCALE_ENV = "locale.env";
        public static final String DATASETS_ENV = "datasets.env";
    }
}
