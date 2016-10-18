package cc.sb.cache.api;

/**
 * Storage the store key-value pairs. Provide the ability to load value by the key.
 * Do not allow null keys or values.
 */
public interface Storage<K, V> {

    /**
     * Saves the key with the value.
     *
     * @param key the key whose associated value
     * @throws NullPointerException if the key is null
     */
    void save(K key, V value);


    /**
     * Loads the value by the key.
     *
     * @param key the key whose associated value
     */
    V load(K key);

}
