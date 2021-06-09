package ai.testvagrant.ekam.commons.modules;

import ai.testvagrant.ekam.commons.cache.DataSetsCache;
import ai.testvagrant.ekam.commons.cache.DataSetsProvider;
import com.google.inject.AbstractModule;

public class DataSetsModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DataSetsCache.class).toProvider(DataSetsProvider.class).asEagerSingleton();
    }
}
