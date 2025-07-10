package com.note.pack;

// This is the interface for a List.
public interface List<Item> {
    default public void print() {
        for(int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
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
