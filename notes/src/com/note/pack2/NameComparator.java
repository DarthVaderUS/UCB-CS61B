package com.note.pack2;

import java.util.Comparator;

public class NameComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog d1, Dog d2) {
        return d1.name.compareTo(d2.name); // Compare by name
    }
}
