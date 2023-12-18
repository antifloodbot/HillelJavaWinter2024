package hw7.figures;

public class FiguresRun {
    public static void main(String[] args) {
        GeometricFigure[] figures = {
                new Circle(15),
                new Square(22),
                new Triangle(4.4, 3)
        };
        double totalArea = calculateTotalArea(figures);
        System.out.println("Area of all figures is " + totalArea);

    }

    public static double calculateTotalArea(GeometricFigure[] figures) {
        double totalArea = 0;
        for (GeometricFigure figure : figures) {
            if (figure != null) {
                totalArea += figure.calculateArea();
            }
        }
        return totalArea;
    }
}
