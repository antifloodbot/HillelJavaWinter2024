package hw7.figures;

public class Square implements GeometricFigure {
    public double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
