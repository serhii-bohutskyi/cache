package cc.sb.cache.impl;

import cc.sb.cache.api.Storage;

import java.util.Map;
import java.util.TreeMap;

/**
 * A Tree {@link Storage} implementation.
 */
public class TreeStorage<K, V> extends TreeMap<K, V> implements Storage<K, V> {

    public void save(K key, V value) {
        put(key, value);
    }

    public V load(K key) {
        return get(key);
    }
}
