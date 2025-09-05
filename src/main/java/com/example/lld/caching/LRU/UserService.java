package com.example.lld.caching.LRU;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final LRUCache userCache = new LRUCache(3); // max 100 users

    // Simulate DB/External API call
    private User fetchFromDatabase(Long userId) {
        // In real app → call repository or API
        System.out.println("Fetching from DB for userId: " + userId);
        return new User(userId, "User_" + userId);
    }

    public User getUser(Long userId) {
        User cachedUser = userCache.get(userId);
        if (cachedUser != null) {
            return cachedUser; // return from cache
        }
        User user = fetchFromDatabase(userId);
        userCache.put(userId, user);
        return user;
    }

    public Object showCache() {
        return userCache.getAll();
    }
}

