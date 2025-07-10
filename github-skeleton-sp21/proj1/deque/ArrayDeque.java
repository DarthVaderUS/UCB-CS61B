package deque;

public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int frontPtr;
    private int backPtr;
    private int capacity;
    public ArrayDeque(){
        capacity = 8;
        array = (T[]) new Object[capacity];
        frontPtr = 0;
        backPtr = 0;
        size = 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void update() {
        if (isFull()) {
            resize(capacity * 2);
        } else if (size > 0 && size * 4 < capacity && capacity >= 16) {
            resize((Math.max(capacity / 2, 16)));
        }
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        int index = frontPtr;
        for (int i = 0; i < size; i++) {
            newArray[i] = array[index];
            index = (index + 1) % capacity;
        }
        frontPtr = 0;
        backPtr = size;
        array = newArray;
        capacity = newCapacity;
    }

    public void addFirst(T item) {
        update();
        frontPtr = (frontPtr - 1 + capacity) % capacity;
        array[frontPtr] = item;
        size++;
    }
    public void addLast(T item) {
        update();
        array[backPtr] = item;
        backPtr = (backPtr + 1) % capacity;
        size++;
    }

    public int size() {
        if (size < 0) {
            return 0;
        } else {
            return size;
        }
    }

    public void printDeque() {
        int index = frontPtr;
        while (index != backPtr) {
            System.out.print(array[index]);
            System.out.print(" ");
            index = (index + 1) % capacity;
        }
        System.out.println();
    }

    public T removeFirst() {
        T item = array[frontPtr];
        frontPtr = (frontPtr + 1) % capacity;
        size--;
        update();
        return item;
    }

    public T removeLast() {
        backPtr = (backPtr - 1 + capacity) % capacity;
        T item = array[backPtr];
        size--;
        update();
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int i = frontPtr;
        for (int j = 0; j < index; j++) {
            i = (i + 1) % capacity;
        }
        return array[i];
    }
}
