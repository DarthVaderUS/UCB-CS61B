package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author Zhiyu Chen
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private int size;
    private double loadFactor;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    /** Constructors */
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor maximum load factor
     */
    public MyHashMap(int initialCapacity, double loadFactor) {
        if(initialCapacity < 1) {
            throw new IllegalArgumentException("Initial capacity must be >= 1");
        }
        if(loadFactor <= 0) {
            throw new IllegalArgumentException("Load factor must be > 0");
        }
        this.loadFactor = loadFactor;
        this.size = 0;
        buckets = createTable(initialCapacity);
    }

    /**
     * Creates a new bucket array with given capacity.
     */
    @SuppressWarnings("unchecked")
    private Collection<Node>[] createTable(int capacity) {
        Collection<Node>[] table = new Collection[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = createBucket();
        }
        return table;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *  Note that that this is referring to the hash table bucket itself,
     *  not the hash map itself.
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        // TODO: Fill in this method.
        return new LinkedList<>();
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

    /** Hash function: ensure non-negative index */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % buckets.length;
    }

    private void resize(int newCapacity) {
        Collection<Node>[] oldBuckets = buckets;
        buckets = createTable(newCapacity);
        size = 0; // will re-count during reinsertion
        for (Collection<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys not allowed");
        }
        int idx = hash(key);
        for (Node node : buckets[idx]) {
            if (node.key.equals(key)) {
                node.value = value; // overwrite
                return;
            }
        }
        buckets[idx].add(new Node(key, value));
        size++;
        if ((double) size / buckets.length > loadFactor) {
            resize(buckets.length * 2);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) return null;
        int idx = hash(key);
        for (Node node : buckets[idx]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("null keys not supported");
        }
        if (buckets == null || buckets.length == 0) {
            return false;
        }
        int idx = Math.floorMod(key.hashCode(), buckets.length);
        Collection<Node> bucket = buckets[idx];
        if (bucket == null) {
            return false;
        }
        for (Node n : bucket) {
            if (n.key.equals(key)) {   // 注意用 equals 比较键
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        buckets = createTable(DEFAULT_INITIAL_CAPACITY);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Collection<Node> bucket : buckets) {
            for (Node node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    @Override
    public V remove(K key) {
        if (key == null) return null;
        int idx = hash(key);
        Iterator<Node> it = buckets[idx].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key.equals(key)) {
                V val = node.value;
                it.remove();
                size--;
                return val;
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }


}
