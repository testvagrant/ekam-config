package ai.testvagrant.ekam.commons.modules;

import ai.testvagrant.ekam.commons.cache.LocaleCache;
import ai.testvagrant.ekam.commons.cache.LocaleProvider;
import com.google.inject.AbstractModule;

public class LocaleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LocaleCache.class).toProvider(LocaleProvider.class).asEagerSingleton();
    }
}
