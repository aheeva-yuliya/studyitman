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
}