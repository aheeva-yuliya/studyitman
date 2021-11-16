package entities;

/**
 * BfsNode
 */
public class BfsNode {
    private final int vertex;
    private final int distance;
    private BfsNode prev;

    public BfsNode(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public BfsNode(int vertex, int distance, BfsNode prev) {
        this.vertex = vertex;
        this.distance = distance;
        this.prev = prev;
    }

    public int getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }

    public BfsNode getPrev() {
        return prev;
    }

    /**
     * Returns a string with information about the instance variables of the object.
     *
     * @cpu O(n) n - number of linked nodes
     * @ram O(n) n - number of linked nodes
     *
     * @return a string with information about the instance variables of the object.
     */
    public String toString() {
        return "BfsNode{vertex=" + vertex + ", distance=" + distance + ", prev=" + prev + "}";
    }

    /**
     * Indicates whether some other object is "equal to" this one .
     *
     * @cpu O(n), n - number of linked nodes
     * @ram O(1)
     *
     * @param that an object argument
     * @return true if the objects are equal and false if aren't.
     */
    public boolean equals(BfsNode that) {
        return that != null && vertex == that.vertex && distance == that.distance
                && (prev == null && that.prev == null
                || prev != null && prev.equals(that.prev));
    }
}
