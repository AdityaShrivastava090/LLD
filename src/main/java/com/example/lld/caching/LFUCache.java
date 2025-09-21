package com.example.lld.caching;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        Node(int k, int v) {
            key = k;
            value = v;
            frequency = 1; // ✅ fix: start frequency at 1
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                removeNode(node);
                return node;
            }
            return null;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> nodeMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
        } else {
            if (capacity == nodeMap.size()) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node evictedNode = minList.removeLast();
                nodeMap.remove(evictedNode.key); // ✅ fix: remove by key
            }

            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            minFreq = 1; // reset minFreq
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        }
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;

        Node node = nodeMap.get(key);
        update(node);
        return node.value;
    }

    private void update(Node node) {
        int freq = node.frequency;
        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.removeNode(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.frequency++;
        freqMap.computeIfAbsent(node.frequency, k -> new DoublyLinkedList()).addNode(node);
    }
}

class LFUMain {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);

        lfu.put(1, 10); // Cache = {1=10}
        lfu.put(2, 20); // Cache = {2=20, 1=10}

        System.out.println(lfu.get(1)); // returns 10 (freq of 1=2)
        lfu.put(3, 30); // evicts key=2 (freq=1), Cache = {3=30, 1=10}

        System.out.println(lfu.get(2)); // -1 (not found)
        System.out.println(lfu.get(3)); // 30
        System.out.println(lfu.get(1)); // 10 (freq=3)

        lfu.put(4, 40); // evicts key=3 (freq=1), Cache = {4=40, 1=10}

        System.out.println(lfu.get(3)); // -1
        System.out.println(lfu.get(4)); // 40
        System.out.println(lfu.get(1)); // 10
    }
}
