package com.note.pack;

// This is the interface for a List.
public interface List<Item> {
    public void insert(Item x, int position);
    public void addLast(Item x);
    public void addFirst(Item x);
    public Item get(int position);
    public Item getFirst();
    public Item getLast();
    public Item remove(int position);
    public Item removeLast();
    public Item removeFirst();
    public int size();

}
