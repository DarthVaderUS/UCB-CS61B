package com.note.pack6.Graph;

import java.util.*;

public class Graph {
    private final int V; // Num of vertices
    private int E;   // Num of total edges
    private List<Integer>[] adj;  // Adjacency list

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Undirected graph
        E++;
    }

    /** Get all adjacent vertices of vertex v in List
     * @param v vertex
     * @return all adjacent vertices of vertex v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}
