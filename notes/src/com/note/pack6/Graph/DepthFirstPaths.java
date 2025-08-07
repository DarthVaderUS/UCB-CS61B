package com.note.pack6.Graph;

public class DepthFirstPaths {
    private boolean[] marked; // Is vertex v reachable from source s?
    private int[] edgeTo;      // Last vertex on known path to vertex v
    private final int s;       // Source vertex

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        java.util.LinkedList<Integer> path = new java.util.LinkedList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.addFirst(x);
        }
        path.addFirst(s);
        return path;
    }
}
