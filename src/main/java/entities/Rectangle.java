package entities;

public class Rectangle extends Shape {
    private final int width;
    private final int height;

    public Rectangle(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public double calcPerimeter() {
        return 2.0 * width + 2.0 * height;
    }

    @Override
    public double calcSquare() {
        return (double) width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + "}";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }
        final Rectangle rectangle = (Rectangle) o;
        return height == rectangle.height && width == rectangle.width;
    }
}
