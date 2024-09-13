package com.myproject.code.linkedlist;

import java.util.HashMap;
import java.util.Map;
/*
* Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
* */
public  class LRUCache {
        private Map<Integer, NodeL> mpp; // Map data structure
        private int cap; // Capacity
        private NodeL head; // Dummy head pointer
        private NodeL tail; // Dummy tail pointer

        public LRUCache(int capacity) {
            cap = capacity; // Set the capacity
            mpp = new HashMap<>(); // Clear the cache

            head = new NodeL();
            tail = new NodeL();

            // Make the connections
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            // Return -1 if it is not present in cache
            if (!mpp.containsKey(key))
                return -1;

            NodeL node = mpp.get(key); // Get the node
            int val = node.val; // Get the value

            // Delete the node
            deleteNode(node);
            /*
             * Insert this node to front
             * as it was recently used
             */
            insertAfterHead(node);

            // Return the stored value
            return val;
        }

        public void put(int key, int value) {
            // Update the value if key is already present
            if (mpp.containsKey(key)) {

                NodeL node = mpp.get(key); // Get the node
                node.val = value; // Update the value

                // Delete the node
                deleteNode(node);

                /*
                 * Insert this node to front
                 * as it was recently used
                 */
                insertAfterHead(node);

                return;
            }

            // Check if the capacity limit has reached
            if (mpp.size() == cap) {

                // Get the least recently used node
                NodeL node = tail.prev;

                // Delete node from map
                mpp.remove(node.key);

                // Delete node from doubly linked list
                deleteNode(node);
            }

            // Create a new node
            NodeL newNode = new NodeL(key, value);

            // Insert it in map
            mpp.put(key, newNode);

            // Insert in doubly linked list
            insertAfterHead(newNode);
        }

        private void deleteNode(NodeL node) {

            // Get the previous and next pointers
            NodeL prevNode = node.prev;
            NodeL nextNode = node.next;

            // Remove pointers to node
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // Private method to insert node after head
        private void insertAfterHead(NodeL node) {

            NodeL nextNode = head.next;
            head.next = node;
            nextNode.prev = node;
            node.prev = head;
            node.next = nextNode;
        }
    }
class NodeL {
    public int key, val;
    public NodeL next, prev;

    // Constructors
    NodeL() {
        key = val = -1;
        next = prev = null;
    }

    NodeL(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
