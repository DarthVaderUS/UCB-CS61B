package com.note.pack4.algorithm.disjointSet;

public interface DisjointSets {
    //Connect two items : p and q
    void connect(int p, int q);
    //Checks to see if two items are connected
    boolean isConnected(int p, int q);
}
