package entities;

public class Circle extends Shape {
    private final int radius;

    public Circle(final int radius) {
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return 2 * radius * 3.14;
    }

    @Override
    public double calcSquare() {
        return 3.14 * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + "}";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Circle)) {
            return false;
        }
        final Circle circle = (Circle) o;
        return radius == circle.radius;
    }
}
