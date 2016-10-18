package cc.sb.cache.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A {@link CacheManager} provides a means of creating, configuring {@link Cache}s.
 */
public class CacheManager {

    private final Map<String, Cache> caches;

    public CacheManager() {
        this.caches = new ConcurrentHashMap<String, Cache>();
    }

    /**
     * Gets cache with {@link MemoryStorage} as default storage.
     *
     * @param name the name of the cache
     * @param <K>  the key type
     * @param <V>  the value type
     * @return existed or created cache
     */
    public <K, V> Cache<K, V> getCache(final String name) {
        return getCache(name, new MemoryStorage<K, V>());
    }

    /**
     * Gets cache with provided implementation of {@link Storage}.
     * Creates if not created or closed and saves.
     *
     * @param name    the name of the cache
     * @param storage the storage the
     * @param <K>     the key type
     * @param <V>     the value type
     * @return existed or created cache
     */
    public <K, V> Cache<K, V> getCache(final String name, final Storage<K, V> storage) {
        Cache cache = caches.get(name);
        if (cache == null || cache.isClosed()) {
            synchronized (this) {
                if (cache == null) {
                    cache = new BaseCache<K, V>(name, storage);
                    caches.put(name, cache);
                }
            }
        }
        return cache;
    }

    public void close() {
        for (Cache cache : caches.values()) {
            cache.close();
        }
    }

}
