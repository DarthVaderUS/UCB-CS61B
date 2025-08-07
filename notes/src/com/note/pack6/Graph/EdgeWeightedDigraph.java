package com.note.pack6.Graph;

import java.util.*;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new List[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> all = new ArrayList<>();
        for (int v = 0; v < V; v++)
            all.addAll(adj[v]);
        return all;
    }
}
