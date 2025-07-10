package com.note.pack;

public class SLList<Pineapple> implements List<Pineapple> {
    private int size;   // Efficient size tracking
    /* The first item, if it exists, is at sentinel.next. */
    private IntNode sentinel;

    /* Improved version: Nested class definition */
    private class IntNode {
        public Pineapple item;
        public IntNode next;

        public IntNode(Pineapple i, IntNode n){
            item = i;
            next = n;
        }
    }

    public SLList(){
        sentinel = new IntNode(null, null);
        size = 0;
    }

    /* Create a new SLList with item x. */
    public SLList(Pineapple x){
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /* Add item x to the front of the list. */
    public void addFirst(Pineapple x){
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public void insert(Pineapple x, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        IntNode p = sentinel;
        for (int i = 0; i < position; i++) {
            p = p.next;
        }
        p.next = new IntNode(x, p.next);
        size++;
    }

    public Pineapple get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        IntNode p = sentinel.next;
        for (int i = 0; i < position; i++) {
            p = p.next;
        }
        return p.item;
    }

    public Pineapple remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        IntNode p = sentinel;
        for (int i = 0; i < position; i++) {
            p = p.next;
        }
        Pineapple removed = p.next.item;
        p.next = p.next.next;
        size--;
        return removed;
    }

    public Pineapple removeFirst() {
        if (size == 0) return null;
        Pineapple removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size--;
        return removed;
    }

    public Pineapple removeLast() {
        if (size == 0) return null;
        IntNode p = sentinel;
        for (int i = 0; i < size - 1; i++) {
            p = p.next;
        }
        Pineapple removed = p.next.item;
        p.next = null;
        size--;
        return removed;
    }

    public Pineapple getLast() {
        if (size == 0) return null;
        IntNode p = sentinel.next;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    /* Return the first item of the list. */
    public Pineapple getFirst(){
        if (sentinel.next == null) return null;
        return sentinel.next.item;
    }

    /* Add item x to the end of the list iteratively */
    public void addLast(Pineapple x){
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size++;
    }

    /* Return the size of the list using recursion */
    /* This is a public method, which is called by the users. */
    public int size(){
        return size;
        //return size(first);
    }

    /* Returns this size of the list, starting at IntNode p. */
    /* The users do not need to understand this complicated recursive method,
       they just need to call the public size method above.
     */
//    private int size(IntNode p){
//        if(p.next==null){
//            return 1;
//        }else{
//            return 1+size(p.next);
//        }
//
//    }

    /* Much faster than the default method which inherits from List
    * Because the default method calls get() method every time in the loop, that's pretty slow!!!
    * */
    @Override
    public void print() {
        IntNode p = sentinel.next;
        while(p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>();
        L.addFirst(1);
        L.addLast(2);
        L.insert(3, 1);
        System.out.println("First item: " + L.getFirst());
        System.out.println("Last item: " + L.getLast());
        System.out.println("Size: " + L.size());
        L.removeFirst();
        L.removeLast();
        L.remove(0);
    }
}
