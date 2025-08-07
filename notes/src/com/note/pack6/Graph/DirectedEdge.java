package com.note.pack6.Graph;

/**
 * Directed edge with weight
 * After we implemented the edge, we cannot change the edge's properties,
 * so we use final to declare the properties.
 */
public class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
