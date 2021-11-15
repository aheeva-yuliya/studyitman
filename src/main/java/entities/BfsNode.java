package entities;

public class BfsNode {
    private int vertex;
    private int distance;

    public BfsNode(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public int getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return "{vertex=" + vertex + ", distance=" + distance + "}";
    }

    public boolean equals(BfsNode that) {
        return that != null && vertex == that.vertex && distance == that.distance;
    }
}
