package com.example.lld.caching.LRU;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Long, User> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = Collections.synchronizedMap(
                new LinkedHashMap<Long, User>(capacity, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Long, User> eldest) {
                        return size() > capacity;
                    }
                }
        );
    }

    public User get(Long key) {
        return cache.get(key);
    }

    public void put(Long key, User value) {
        cache.put(key, value);
    }

    public Map<Long, User> getAll() {
        return new LinkedHashMap<>(cache); // snapshot copy
    }
}
