package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CuboidTests {

    @Test
    public void calcSurfaceArea() {
        Cuboid cuboid = new Cuboid(2,6,5);
        Assertions.assertEquals(104, cuboid.calcSurfaceArea());
    }

    @Test
    public void calcVolume() {
        Cuboid cuboid = new Cuboid(2,6,5);
        Assertions.assertEquals(60, cuboid.calcVolume());
    }

    @Test
    public void calcSurfaceAreaIfLong() {
        Cuboid cuboid = new Cuboid(100000,200000,300000);
        Assertions.assertEquals(220000000000L, cuboid.calcSurfaceArea());
    }

    @Test
    public void calcVolumeIfLong() {
        Cuboid cuboid = new Cuboid(10000,20000,30000);
        Assertions.assertEquals(6000000000000L, cuboid.calcVolume());
    }

    @Test
    public void getters() {
        Cuboid cuboid = new Cuboid(10000,20000,30000);
        Assertions.assertEquals(10000,cuboid.getA());
        Assertions.assertEquals(20000,cuboid.getB());
        Assertions.assertEquals(30000,cuboid.getC());
    }

}