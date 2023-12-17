package hw6;

public class Cat extends Animal {
    private static int catsCount = 0;

    public Cat(String name) {
        super(name);
        catsCount++;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength > 0 && obstacleLength <= 200) {
            System.out.println(getName() + " run " + obstacleLength + " meters.");
        } else {
            System.out.println(getName() + " can't run " + obstacleLength + " meters.");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println(getName() + " can't swim");
    }

    public static int getCatsCount() {
        return catsCount;
    }
}
