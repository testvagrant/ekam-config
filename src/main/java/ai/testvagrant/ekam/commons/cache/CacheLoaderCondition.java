package ai.testvagrant.ekam.commons.cache;

public interface CacheLoaderCondition<Key,Value> {
    Value condition(Key key);
}
