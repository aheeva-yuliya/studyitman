package entities;

/**
 * Cuboid
 */
public class Cuboid {
    public int a;
    public int b;
    public int c;

    public Cuboid(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Calculates the surface area of a cuboid.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the surface area of the cuboid.
     */
    public long calcSurfaceArea() {
        return 2 * ((long) a * b + (long) b * c + (long) a * c);
    }

    /**
     * Calculates the volume of a cuboid..
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the volume of the cuboid.
     */
    public long calcVolume() {
        return (long) a * b * c;
    }
}
