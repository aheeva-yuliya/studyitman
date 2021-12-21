package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CuboidTests {
    @Nested
    public class CalcSurfaceArea {
        @Test
        public void shouldCalcSurfaceAreaWhenInteger() {
            Cuboid cuboid = new Cuboid(2, 6, 5);
            Assertions.assertEquals(104, cuboid.calcSurfaceArea());
        }

        @Test
        public void shouldCalcSurfaceAreaWhenLong() {
            Cuboid cuboid = new Cuboid(100000, 200000, 300000);
            Assertions.assertEquals(220000000000L, cuboid.calcSurfaceArea());
        }
    }

    @Nested
    public class CalcVolume {
        @Test
        public void shouldCalcVolumeWhenInteger() {
            Cuboid cuboid = new Cuboid(2, 6, 5);
            Assertions.assertEquals(60, cuboid.calcVolume());
        }

        @Test
        public void shouldCalcVolumeWhenLong() {
            Cuboid cuboid = new Cuboid(10000, 20000, 30000);
            Assertions.assertEquals(6000000000000L, cuboid.calcVolume());
        }
    }

    @Nested
    public class Get {
        @Test
        public void shouldGetWhenTryGet() {
            Cuboid cuboid = new Cuboid(10000, 20000, 30000);
            Assertions.assertEquals(10000, cuboid.getA());
            Assertions.assertEquals(20000, cuboid.getB());
            Assertions.assertEquals(30000, cuboid.getC());
        }
    }
}