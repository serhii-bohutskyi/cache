package cc.sb.cache.impl;

import cc.sb.cache.api.Storage;

import java.util.Map;
import java.util.TreeMap;

/**
 * A {@link Storage} tree implementation.
 * As example implementation of different storages.
 */
public class TreeStorage<K, V> implements Storage<K, V> {

    private Map<K, V> tree = new TreeMap<K, V>();

    public void save(K key, V value) {
        tree.put(key, value);
    }

    public V load(K key) {
        return tree.get(key);
    }
}
