package com.example.lld.rateLimiting;

public class TokenBucket {
    private final long capacity;       // Max tokens
    private final double fillRate;     // Tokens per second
    private double tokens;             // Current tokens
    private long lastRefillTimestamp;  // Last refill time (millis)

    public TokenBucket(long capacity, double fillRate) {
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.tokens = capacity;  // Start full
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean tryConsume() {
        refill();

        if (tokens >= 1) {
            tokens -= 1; // use one token
            return true; // request allowed
        }
        return false; // request denied
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastRefillTimestamp;

        // tokens to add = elapsed_time_in_seconds * fillRate
        double tokensToAdd = (elapsed / 1000.0) * fillRate;

        // Cap tokens at capacity
        tokens = Math.min(capacity, tokens + tokensToAdd);

        lastRefillTimestamp = now;
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(5, 1); // capacity=5, refill=1/sec

        // Send 7 requests instantly
        for (int i = 1; i <= 7; i++) {
            System.out.println("Request " + i + ": " + (bucket.tryConsume() ? "Allowed ✅" : "Denied ❌"));
        }

        // Wait 3 seconds to let tokens refill
        Thread.sleep(3000);

        // Send 3 more requests
        for (int i = 8; i <= 10; i++) {
            System.out.println("Request " + i + ": " + (bucket.tryConsume() ? "Allowed ✅" : "Denied ❌"));
        }
    }
}

