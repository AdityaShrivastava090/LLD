package com.example.lld.caching;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node new_node = new Node(key, value);

            if (cache.size() == capacity) {
                Node LRU_NODE = tail.prev;
                cache.remove(LRU_NODE.key);
                remove(LRU_NODE);
            }
            cache.put(key, new_node);
            add(new_node);
        } else {
            node.value = value;
            addInFront(node);
        }
    }

    public void addInFront(Node node) {
        remove(node);
        add(node);
    }

    private void remove(Node node) {
        if (node == null || node.prev == null || node.next == null) return;

        Node prev_nbr = node.prev;
        Node next_nbr = node.next;

        prev_nbr.next = next_nbr;
        next_nbr.prev = prev_nbr;

        node.next = null;
        node.prev = null;
    }

    private void add(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        addInFront(node);
        return node.value;
    }
}

class LRUMain {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2); // capacity = 2

        lru.put(1, 10);  // Cache = {1=10}
        lru.put(2, 20);  // Cache = {2=20, 1=10}
        System.out.println(lru.get(1)); // returns 10 → Cache = {1=10, 2=20}

        lru.put(3, 30);  // Evicts key=2 → Cache = {3=30, 1=10}
        System.out.println(lru.get(2)); // returns -1 (not found)

        lru.put(4, 40);  // Evicts key=1 → Cache = {4=40, 3=30}
        System.out.println(lru.get(1)); // returns -1
        System.out.println(lru.get(3)); // returns 30 → Cache = {3=30, 4=40}
        System.out.println(lru.get(4)); // returns 40 → Cache = {4=40, 3=30}
    }
}
