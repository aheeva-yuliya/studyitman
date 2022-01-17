package entities;

public class Square extends Shape {
    private final int side;

    public Square(final int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double calcPerimeter() {
        return 4.0 * side;
    }

    @Override
    public double calcSquare() {
        return (double) side * side;
    }

    @Override
    public String toString() {
        return "Square{side=" + side + "}";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Square)) {
            return false;
        }
        final Square square = (Square) o;
        return side == square.side;
    }
}
