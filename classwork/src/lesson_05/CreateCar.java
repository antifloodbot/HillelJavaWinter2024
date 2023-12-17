package lesson_05;

public class CreateCar {
    public static void main(String[] args) {

        Car c = new Car();

        c.setModel("Tesla");
        c.setType("electric");
        c.setColor("red");
        c.setYear("2020");
        c.setNumber("336");

        System.out.println(c);
        validateCar(c);
    }

    private static void validateCar(Car car){
        if (car.getColor() == null || car.getYear() == null || car.getModel() == null)
            System.out.println("invalid car : " + car);
        else System.out.println("valid car : " + car);
    }
}
