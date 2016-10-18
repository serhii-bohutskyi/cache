# Simple Cache

Simple Cache is implementation of base cache logic with different storages. 
To use cache implement your Storage or use default MemoryStorage. 

### Simple Application
```java
User user =...
String name = ...

//create manager        
CacheManager cacheManager = new CacheManager();
//get user cache 
Cache<String, User> userCache = cacheManager.getCache("UserCache");

//put into cache        
userCache.put(name, user);
//get from cache
User user = userCache.get(name);

```

### Application with TreeStorage
```java
User user =...
String name = ...

//create manager        
CacheManager cacheManager = new CacheManager();
//get user cache 
Cache<String, User> userCache = cacheManager.getCache("UserCache", new TreeStorage());

//put into cache        
userCache.put(name, user);
//get from cache
User user = userCache.get(name);

```
### The Cache Interface
Cache interface describes simple operations. See the methods below.
```java
public interface Cache<K, V> {
    V get(K key);
    void put(K key, V value);
    String getName();
    boolean isClosed();
    void close();
}
```
### The Storage Interface
Storage interface describes basic methods to store key-value pair. See the methods below.
```java
public interface Storage<K, V> {
    void save(K key, V value);
    V load(K key);
}
```

### Storage Implementations

#### ```javaLruStorage```  -  A Least Recently Used Implementation
#### ```javaMruStorage```  -  A Most Recently Used Implementation.
#### ```javaTreeStorage``` -  A Tree Implementation.

Storage implementation can be such as memory storage, file storage, database storage, etc.
Its implementation depends on your need. For example you can use different memory storages with more or less productive algorithms.

