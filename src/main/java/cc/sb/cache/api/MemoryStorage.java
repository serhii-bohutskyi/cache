package cc.sb.cache.api;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Memory implementation of {@link Storage}.
 */
class MemoryStorage<K, V> implements Storage<K, V> {

    private final Map<K, V> map;

    public MemoryStorage() {
        this.map = new ConcurrentHashMap<K, V>();
    }

    public void save(final K key, final V value) {
        map.put(key, value);
    }

    public V load(final K key) {
        return map.get(key);
    }
}
