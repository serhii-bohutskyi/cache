package cc.sb.cache.api;

/**
 * Internal exceptions wrapped by {@link CacheException}.
 */
public class CacheException extends RuntimeException {

    public CacheException(final String message) {
        super(message);
    }

    public CacheException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
