package hw6;

public abstract class Animal {
    public static int animalCount = 0;
    private String name;

    public String getName() {
        return name;
    }

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int obstacleLength) {
        System.out.println(name + " run " + obstacleLength + " meters.");
    }

    public void swim(int obstacleLength) {
        System.out.println(name + " swim " + obstacleLength + " meters.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
