package cc.sb.cache.impl;

import cc.sb.cache.api.Storage;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * A Most Recently Used {@link Storage} implementation.
 */
public class MruStorage<K, V> extends LinkedHashMap<K, V> implements Storage<K, V> {

    private int capacity;

    public MruStorage(int capacity) {
        super(capacity + 1, 1.0f, false);// mru
        this.capacity = capacity;
    }

    public void save(K key, V value) {
        put(key, value);
    }

    public V load(K key) {
        return get(key);
    }

    protected boolean removeEldestEntry(Map.Entry entry) {
        return (size() > this.capacity);
    }

}