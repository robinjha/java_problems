package com.java.cache;

/**
 * Your cache implementation should provide the following :

    - Guarantee that there is a single instance of the cache
    - Type safety
    - Thread safety

 * @author robin
 *
 */
public interface Cache {
    public void put(Object key, Object value);
    public Object get(Object key);
}

