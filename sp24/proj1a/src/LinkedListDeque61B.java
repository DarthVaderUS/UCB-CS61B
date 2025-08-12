import java.util.*;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private int size;

    // Non-static inner class, uses outer T
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(Node prev, T item, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node Sentinel;

    public LinkedListDeque61B() {
        size = 0;
        Sentinel = new Node(null, null, null);
        Sentinel.next = Sentinel;
        Sentinel.prev = Sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(Sentinel, x, Sentinel.next);
        Sentinel.next.prev = newNode;
        Sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(Sentinel.prev, x, Sentinel);
        Sentinel.prev.next = newNode;
        Sentinel.prev = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<>();
        Node current = Sentinel.next;
        while (current != Sentinel) {
            result.add(current.item);
            current = current.next;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        Node firstNode = Sentinel.next;
        if (size == 1) {
            Sentinel.next = Sentinel;
            Sentinel.prev = Sentinel;
        } else {
            Sentinel.next = firstNode.next;
            firstNode.next.prev = Sentinel;
        }
        size--;
        return firstNode.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            return null;
        Node lastNode = Sentinel.prev;
        if (size == 1) {
            Sentinel.next = Sentinel;
            Sentinel.prev = Sentinel;
        } else {
            Sentinel.prev = lastNode.prev;
            lastNode.prev.next = Sentinel;
        }
        size--;
        return lastNode.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        Node p = Sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(Sentinel.next, index);
    }

    private T getRecursiveHelper(Node p, int index) {
        if (index == 0){
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }
}