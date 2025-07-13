package com.note.pack3.inheritance4;
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {  /*Add 'implements Iterable<T>' to allow java know
                                                     that this class definitely has an iterator*/
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    //Adds an item to the set. (Ignore duplicates.)
    public void add(T x){
        if(contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    public boolean contains(T x) {
        for(int i = 0; i < size; i++) {
            if(items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    private class ArraySetIterator<T> implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = (T) items[wizPos];
            wizPos++;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator<>();
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //Ugly iteration
        Iterator<Integer> seer = aset.iterator();
        while(seer.hasNext()){
            Integer i = seer.next();
            System.out.println(i);
        }

        //Nice Iterator
        for(int i : aset) {
            System.out.println(i);
        }
    }


}

