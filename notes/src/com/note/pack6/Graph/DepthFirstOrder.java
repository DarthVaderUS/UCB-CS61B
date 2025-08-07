package com.note.pack6.Graph;

import java.util.*;

public class DepthFirstOrder {
    private boolean[] marked;
    private Deque<Integer> reversePost;
    private boolean[] onStack;
    private boolean hasCycle;

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        reversePost = new ArrayDeque<>();

        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (hasCycle) return;
            if (!marked[w]) dfs(G, w);
            else if (onStack[w]) hasCycle = true;
        }
        onStack[v] = false;
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
