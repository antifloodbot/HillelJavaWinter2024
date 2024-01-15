package hw13;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("Alen");
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-van");
        coffeeOrderBoard.add("John Snow");

        System.out.println("Check the queue:");
        coffeeOrderBoard.draw();

        System.out.println("\nDeliver order by queue:");
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

        System.out.println("\nDeliver order by order number:");
        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.draw();

        System.out.println("\nDeliver non existed order:");
        coffeeOrderBoard.deliver(10);
    }
}
