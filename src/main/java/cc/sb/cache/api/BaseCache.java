package cc.sb.cache.api;

/**
 * Base implementation of {@link Cache}.
 */
class BaseCache<K, V> implements Cache<K, V> {

    private final String name;
    private final Storage<K, V> storage;
    private boolean isClosed;

    public BaseCache(final String name, final Storage<K, V> storage) {
        this.name = name;
        this.storage = storage;
    }

    public V get(final K key) {
        checkClosed();

        if (key == null) {
            throw new NullPointerException("Key cannot be a null!");
        }
        try {
            return storage.load(key);
        } catch (RuntimeException e) {
            throw new CacheException("Exception while loading value from storage!", e);
        }
    }

    public void put(final K key, final V value) {
        checkClosed();

        if (key == null) {
            throw new NullPointerException("Key cannot be a null!");
        }
        try {
            storage.save(key, value);
        } catch (RuntimeException e) {
            throw new CacheException("Exception while saving to storage!", e);
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public void close() {
        this.isClosed = true;
    }

    private void checkClosed() {
        if (isClosed()) {
            throw new IllegalStateException("Cache is closed!");
        }
    }
}
