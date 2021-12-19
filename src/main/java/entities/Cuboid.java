package entities;

/**
 * Cuboid.
 */
public class Cuboid {
    private final int high;
    private final int width;
    private final int length;

    public Cuboid(int a, int b, int c) {
        this.high = a;
        this.width = b;
        this.length = c;
    }

    /**
     * Gets the value of the instance variable "high".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "high"
     */
    public int getHigh() {
        return high;
    }

    /**
     * Gets the value of the instance variable "width".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "width"
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the value of the instance variable "length".
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value of the instance variable "length"
     */
    public int getLength() {
        return length;
    }

    /**
     * Calculates the surface area of high cuboid.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the surface area of the cuboid.
     */
    public long calcSurfaceArea() {
        return 2 * ((long) high * width + (long) width * length + (long) high * length);
    }

    /**
     * Calculates the volume of high cuboid.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the value equals to the volume of the cuboid.
     */
    public long calcVolume() {
        return (long) high * width * length;
    }
}
