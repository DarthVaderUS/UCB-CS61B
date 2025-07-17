package com.note.pack4.algorithm.disjointSet;

public class QuickUnionDS {
    private int[] parent;
    public QuickUnionDS(int N){
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }
    private int find(int p) {
        int r = p;
        while(parent[r] >= 0) {
            r = parent[r];
        }
        return r;
    }
    public void connect(int p ,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP != rootQ) {
            parent[rootP] = rootQ; // Connect root of p to root of q
        }
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
