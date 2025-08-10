package deque;


public class LinkedListDeque<T> implements Deque<T> {
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        /*Constructor for an empty node */
        public Node() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }

        /*Constructor for a node with a item, with prev and next. */
        public Node(Node<T> prev, T item, Node<T> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        /* Constructor for a node with an input item, without prev and next.*/
        public Node(T i) {
            prev = null;
            item = i;
            next = null;
        }

        public Node(Node<T> prev, T item){
            this.item = item;
            this.next = null;
            this.prev = prev;
        }

        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
            this.prev = null;
        }
    }

    private Node<T> headSentinel;
    private Node<T> tailSentinel;

    /**
     * Creates an empty LinkedListDeque.
     * Initializes the head and tail sentinels to null.
     */
    public LinkedListDeque() {
        size = 0;
        headSentinel = null;
        tailSentinel = null;
    }

    /**
     * Creates a LinkedListDeque with a single item.
     * Initializes the head and tail sentinels to the same item.
     * @param item The item to be added to the deque.
     */
    public LinkedListDeque(T item) {
        headSentinel = new Node<T>(item);
        tailSentinel = new Node<T>(item);
        size = 1;
    }

    /*Add the first item of type T to the front of the deque. */
    public void addFirst(T item) {
        headSentinel = new Node<>(item, headSentinel);
        if(size > 0) {
            headSentinel.next.prev = headSentinel;
        }else{
            tailSentinel = headSentinel;
        }
        size++;
    }

    public void addLast(T item) {
        tailSentinel = new Node<>(tailSentinel, item);
        if(size > 0){
            tailSentinel.prev.next = tailSentinel;
        }else{
            headSentinel = tailSentinel;
        }
        size++;
    }

//    public boolean isEmpty() {
//        return size == 0;
//    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> p = headSentinel;
        while(p != null) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.print("\n");
    }

    /*Removes and returns the item at the front of the deque
     * If no item exists, return null;
     */
    public T removeFirst() {
        if(isEmpty())
            return null;
        Node<T> p = headSentinel;
        if(size == 1){
            headSentinel = null;
            tailSentinel = null;
        }
        else{
            headSentinel = headSentinel.next;
            headSentinel.prev = null;
        }
        size--;
        return p.item;
    }

    /*Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if(isEmpty())
            return null;
        Node<T> p = tailSentinel;
        if(size == 1){
            headSentinel = null;
            tailSentinel = null;
        }
        else{
            tailSentinel = tailSentinel.prev;
            tailSentinel.next = null;
        }
        size--;
        return p.item;
    }

     /*
    Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque!
    */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }else{
            Node<T> p = headSentinel;
            for(int i = 0;i < index;i++) {
                p = p.next;
            }
            return p.item;
        }
    }

    /* Recursion version of the get method; */
    public T getRecursive(int index) {
        if(index < 0 || index >= size) {
            return null;
        }else{
            return getRecursiveHelper(headSentinel, index);
        }
    }

    /* The implementation of the recursion */
    private T getRecursiveHelper(Node<T> p, int index) {
        if(index == 0) {
            return p.item;
        }else{
            return getRecursiveHelper(p.next, index - 1);
        }
    }

}
