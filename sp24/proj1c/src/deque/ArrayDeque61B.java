package deque;

import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] items;
    private int size;
    private int head; // Index of the first element
    private int tail; // Index of the next available position

    public ArrayDeque61B() {
        items = (T[]) new Object[16];
        size = 0;
    }
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = items[(head + i) % items.length];
        }
        items = a;
        head = 0; // Reset head to the start of the new array
        tail = size; // Reset tail to the end of the current elements
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        head = (head - 1 + items.length) % items.length; // Move head back
        items[head] = x;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length){
            resize(size * 2);
        }
        items[tail] = x;
        tail = (tail + 1) % items.length; // Move tail forward
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> result = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(items[(head + i) % items.length]);
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
        if(isEmpty()) {
            return null;
        }
        if(size == items.length / 4 && items.length > 16) {
            resize(items.length / 2); // Shrink the array if it's too large
        }
        T firstItem = items[head];
        items[head] = null; // Clear the first item
        head = (head + 1) % items.length; // Move head forward
        size--;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == items.length / 4 && items.length > 16) {
            resize(items.length / 2); // Shrink the array if it's too large
        }
        tail = (tail - 1 + items.length) % items.length; // Move tail
        T lastItem = items[tail];
        items[tail] = null; // Clear the last item
        size--;
        return lastItem;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return items[(head + index) % items.length];
    }

    @Override
    public T getRecursive(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getRecursiveHelper((head + index) % items.length);
    }

    private T getRecursiveHelper(int idx) {
        if (idx == head) {
            return items[head];
        }
        return getRecursiveHelper((idx - 1 + items.length) % items.length);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = head;
            private int elementsReturned = 0;

            @Override
            public boolean hasNext() {
                return elementsReturned < size;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T item = items[currentIndex];
                currentIndex = (currentIndex + 1) % items.length;
                elementsReturned++;
                return item;
            }
        };
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArrayDeque61B<?> that)) {
            return false;
        }
        if (this.size != that.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.get(i).equals(that.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return toList().toString();
    }

}
