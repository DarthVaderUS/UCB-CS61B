package com.note.pack;

public class SLList<Pineapple> {
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

    /* Return the first item of the list. */
    public Pineapple getFirst(){
        return sentinel.next.item;
    }

    /* Add item x to the end of the list iteratively */
    public void addLast(Pineapple x){
        size++;
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
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

    public static void main(String[] args) {
        // Test the SLList class
        SLList<String> L= new SLList<String>();
        L.addFirst("Hello");
        L.addLast("World");
        System.out.println("First item: " + L.getFirst());
        SLList<Integer> L2 = new SLList<Integer>(5);  //Note: We must use "Integer" here, not "int"
    }
}
