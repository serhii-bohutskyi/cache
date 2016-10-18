package cc.sb.cache;

import cc.sb.cache.api.Cache;
import cc.sb.cache.api.CacheManager;
import cc.sb.cache.data.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * @author Serhii_Bohutskyi
 */
public class CacheTest {

    @Test
    public void nameTest() {
        CacheManager cacheManager = new CacheManager();
        Cache<String, User> userCache = cacheManager.getCache("UserCache");

        Assert.assertEquals("UserCache", userCache.getName());
    }

    @Test
    public void putTest() {
        CacheManager cacheManager = new CacheManager();
        Cache<String, User> userCache = cacheManager.getCache("UserCache");

        User user1 = randomUser();
        User user2 = randomUser();
        User user3 = randomUser();
        User user4 = randomUser();
        User user = new User("Serhii");

        userCache.put(user1.getName(), user1);
        userCache.put(user2.getName(), user2);
        userCache.put(user.getName(), user);
        userCache.put(user3.getName(), user3);
        userCache.put(user4.getName(), user4);

        User cachedUser = userCache.get(user.getName());

        Assert.assertNotNull(cachedUser);
        Assert.assertEquals(user, cachedUser);
    }

    @Test(expected = IllegalStateException.class)
    public void closedCacheOperationTest() {
        CacheManager cacheManager = new CacheManager();
        Cache<String, User> cache = cacheManager.getCache("UserCache");

        User user = new User("Serhii");
        cache.put(user.getName(), user);

        cache.close();

        cache.get("Serhii");
    }

    private User randomUser() {
        return new User(UUID.randomUUID().toString());
    }
}
