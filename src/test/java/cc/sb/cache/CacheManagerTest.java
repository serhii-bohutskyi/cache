package cc.sb.cache;

import cc.sb.cache.api.Cache;
import cc.sb.cache.api.CacheManager;
import cc.sb.cache.data.User;
import cc.sb.cache.impl.TreeStorage;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Serhii_Bohutskyi
 */
public class CacheManagerTest {

    @Test
    public void defaultGetCacheTest() {
        CacheManager cacheManager = new CacheManager();
        Cache<String, User> userCache1 = cacheManager.getCache("UserCache");

        Assert.assertNotNull(userCache1);

        Cache<String, User> userCache2 = cacheManager.getCache("UserCache");

        Assert.assertEquals(userCache1, userCache2);

    }

    @Test(expected = IllegalStateException.class)
    public void closeTest() {
        CacheManager cacheManager = new CacheManager();
        Cache<String, User> userCache = cacheManager.getCache("UserCache");

        User user = new User("Serhii");
        userCache.put(user.getName(), user);

        cacheManager.close();

        userCache.get(user.getName());
    }

    @Test
    public void getCacheWithStorageTest() {
        CacheManager cacheManager = new CacheManager();
        Cache<String, User> userCache1 = cacheManager.getCache("UserCache", new TreeStorage<String, User>());

        Assert.assertNotNull(userCache1);

        Cache<String, User> userCache2 = cacheManager.getCache("UserCache");

        Assert.assertEquals(userCache1, userCache2);

    }
}
