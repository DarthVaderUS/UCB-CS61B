package com.note.pack6.Graph;

import java.util.*;

public class Topological {
    private Iterable<Integer> order;

    public Topological(EdgeWeightedDigraph G) {
        DepthFirstOrder dfs = new DepthFirstOrder(G);
        if (!dfs.hasCycle()) {
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean hasOrder() {
        return order != null;
    }
}
