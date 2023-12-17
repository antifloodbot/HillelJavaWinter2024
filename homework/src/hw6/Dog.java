package hw6;

public class Dog extends Animal {
    private static int dogsCount = 0;

    public Dog(String name) {
        super(name);
        dogsCount++;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength > 0 && obstacleLength <= 500) {
            System.out.println(getName() + " run " + obstacleLength + " meters.");
        } else {
            System.out.println(getName() + " can't run " + obstacleLength + " meters.");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        if (obstacleLength > 0 && obstacleLength <= 10) {
            System.out.println(getName() + " swim " + obstacleLength + " meters.");
        } else {
            System.out.println(getName() + " can't swim " + obstacleLength + " meters.");
        }
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
