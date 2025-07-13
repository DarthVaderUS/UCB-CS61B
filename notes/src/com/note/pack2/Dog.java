package com.note.pack2;

public class Dog implements OurComparable{
    public String name;
    private int size;

    @Override
    public int compareTo(Object o) {
        Dog otherDog = (Dog) o;
        return this.size - otherDog.size; // Compare by siz
    }
}
