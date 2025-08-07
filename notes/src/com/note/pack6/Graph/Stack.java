package com.note.pack6.Graph;

import java.util.*;

public class Stack<T> implements Iterable<T> {
    private Deque<T> stack = new ArrayDeque<>();

    public void push(T item) {
        stack.push(item);
    }

    public T pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Iterator<T> iterator() {
        return stack.iterator();
    }
}
