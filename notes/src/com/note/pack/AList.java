package com.note.pack;

public class AList<Item> implements List<Item> {
    private Item[] items;
    private int size;

    /*Creates an empty list*/
    public AList(){
        items = (Item[]) new Object[100];
        size = 0;
    }

    /* Resizes the underlying array to the target capacity. */
    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /* Inserts X into the back of the list */
    @Override      /* Adds an "@Override" : Reminds Programmer that method definition
                      is overriding a method in the interface List<Item> */
    public void addLast(Item x){
        if (size == items.length){
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    @Override
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
        size++;
    }

    @Override
    public void insert(Item x, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == items.length) {
            resize(size * 2);
        }
        System.arraycopy(items, position, items, position + 1, size - position);
        items[position] = x;
        size++;
    }

    @Override
    /* Returns the item from the back of the list. */
    public Item getLast(){
        return items[size - 1];
    }

    /*Get the ith item in the list, */
    @Override
    public Item get(int i){
        return items[i];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Item getFirst() {
        if (size == 0) return null;
        return items[0];
    }

    @Override
    public Item removeFirst() {
        if (size == 0) return null;
        Item x = items[0];
        System.arraycopy(items, 1, items, 0, size - 1);
        items[size - 1] = null;
        size--;
        return x;
    }

    @Override
    public Item remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        Item x = items[position];
        System.arraycopy(items, position + 1, items, position, size - position - 1);
        items[size - 1] = null;
        size--;
        return x;
    }

    /* Removes the item from the back of the list and returns it. */
    @Override
    public Item removeLast(){
        if (size == 0) return null;
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    public static void main(String[] args) {
        AList<Integer> L = new AList<>();
        for(int i = 0; i < 10000000; i++){
            L.addLast(i + 1);
        }
    }
}
