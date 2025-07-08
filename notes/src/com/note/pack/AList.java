package com.note.pack;

public class AList {
    private int[] items;
    private int size;

    /*Creates an empty list*/
    public AList(){
        items = new int[100];
        size = 0;
    }

    /* Resizes the underlying array to the target capacity. */
    private void resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /* Inserts X into the back of the list */
    public void addLast(int x){
        if (size == items.length){
            resize(size + 1);
        }
        items[size] = x;
        size++;
    }

    /* Returns the item from the back of the list. */
    public int getLast(){
        return items[size - 1];
    }

    /*Get the ith item in the list, */
    public int get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    /* Removes the item from the back of the list and returns it. */
    public int removeLast(){
        int x = getLast();
        items[size - -1] = 0;
        size -= 1;
        return x;
    }


}
