package cc.sb.cache.api;

/**
 * Cache is a data structure that provides temporary storage of application data.
 */
public interface Cache<K, V> {

    /**
     * Gets an entry from the cache.
     *
     * @param key the key whose associated value is to be returned
     * @return the element, or null, if it does not exist.
     * @throws IllegalStateException if the cache is closed
     * @throws NullPointerException  if the key is null
     * @throws CacheException        if there is a problem fetching the value
     */
    V get(K key);


    /**
     * Puts the specified value and the specified key in the cache.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @throws IllegalStateException if the cache is closed
     * @throws NullPointerException  if key is null or if value is null
     * @throws CacheException        if there is a problem doing the put
     */
    void put(K key, V value);

    /**
     * Gets the name of the cache.
     *
     * @return the name of the cache
     */
    String getName();

    /**
     * Determines cache instance state.
     *
     * @return true if this cache is closed; false if it is open
     */
    boolean isClosed();

    /**
     * Closes the cache.
     * If cache closed any operations cannot be done
     */
    void close();
}
