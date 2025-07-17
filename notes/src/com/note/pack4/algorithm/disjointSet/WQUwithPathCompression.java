package com.note.pack4.algorithm.disjointSet;

public class WQUwithPathCompression implements DisjointSets{
    private int[] parent;
    private int[] size;

    public WQUwithPathCompression(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1; // Initialize each node as its own root
            size[i] = 1; // Each node starts with a size of 1
        }
    }

    private int find(int p) {
        if (parent[p] < 0) {
            return p; // p is the root
        }
        // Path compression: make the parent of p point directly to the root
        parent[p] = find(parent[p]);
        return parent[p];
    }

    @Override
    public void connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            // Union by size: attach smaller tree under larger tree
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
