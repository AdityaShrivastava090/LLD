package com.example.lld.rateLimiting;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowCounter {
    private final int maxRequests;     // Max requests allowed per window
    private final long windowSizeMs;   // Window size in milliseconds
    private long windowStart;          // Start time of current window
    private AtomicInteger counter;     // Request counter

    public FixedWindowCounter(int maxRequests, long windowSizeMs) {
        this.maxRequests = maxRequests;
        this.windowSizeMs = windowSizeMs;
        this.windowStart = System.currentTimeMillis();
        this.counter = new AtomicInteger(0);
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // If current window expired, reset
        if (now - windowStart >= windowSizeMs) {
            windowStart = now;
            counter.set(0);
        }

        if (counter.incrementAndGet() <= maxRequests) {
            return true;  // Allow request
        }

        return false;  // Deny request
    }
}

class FixedWindowCounterMain {
    public static void main(String[] args) throws InterruptedException {
        FixedWindowCounter limiter = new FixedWindowCounter(5, 10000); // 5 requests per 10 sec

        for (int i = 1; i <= 7; i++) {
            System.out.println("Request " + i + ": " +
                    (limiter.allowRequest() ? "Allowed ✅" : "Denied ❌"));
            Thread.sleep(1000); // 1 request per second
        }

        Thread.sleep(10000); // Wait for next window
        System.out.println("New Window Started");

        for (int i = 8; i <= 10; i++) {
            System.out.println("Request " + i + ": " +
                    (limiter.allowRequest() ? "Allowed ✅" : "Denied ❌"));
        }
    }
}

