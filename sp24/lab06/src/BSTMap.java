import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class BSTNode {
        K key;
        V value;
        BSTNode left, right;

        BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private BSTNode root;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null");
        }
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode curNode, K key, V value) {
        if (curNode == null) {
            size++;
            return new BSTNode(key, value);
        }
        int cmp = key.compareTo(curNode.key);
        if (cmp < 0) {
            curNode.left = put(curNode.left, key, value);
        } else if (cmp > 0) {
            curNode.right = put(curNode.right, key, value);
        } else {
            curNode.value = value; // replace existing
        }
        return curNode;
    }

    @Override
    public V get(K key) {
        if(key == null){
            throw new IllegalArgumentException("Key must not be null");
        }
        BSTNode node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private BSTNode getNode(BSTNode node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return getNode(node.left, key);
        if (cmp > 0) return getNode(node.right, key);
        return node;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new java.util.LinkedHashSet<>();
        collectKeysInOrder(root, keys);
        return keys;
    }

    private void collectKeysInOrder(BSTNode node, Set<K> keys) {
        if (node == null) return;
        collectKeysInOrder(node.left, keys);
        keys.add(node.key);
        collectKeysInOrder(node.right, keys);
    }

    @Override
    public V remove(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
        if (!containsKey(key)) {
            return null;
        }
        V value = get(key);
        root = remove(root, key);
        size--;
        return value;
    }

    private BSTNode remove(BSTNode node, K key) {
        if(node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            node.left = remove(node.left, key);
        } else if(cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            // Node to be removed found
            if(node.left == null) {
                return node.right; // No left child, return right subtree
            } else if(node.right == null) {
                return node.left; // No right child, return left subtree
            } else {
                // Node with two children: find the minimum in the right subtree
                BSTNode minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = remove(node.right, minNode.key); // Remove the minimum node
            }
        }
        return node; // Return the updated node
    }
    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public Iterator<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderKeys(root, keys);
        return keys.iterator();
    }

    private void inOrderKeys(BSTNode node, List<K> keys) {
        if (node == null) return;
        inOrderKeys(node.left, keys);
        keys.add(node.key);
        inOrderKeys(node.right, keys);
    }

    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(BSTNode node) {
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key + " -> " + node.value);
        printInOrder(node.right);
    }
}
