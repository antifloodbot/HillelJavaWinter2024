package hw6;

public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik");
        Dog sharik = new Dog("Sharik");
        Cat murzik = new Cat("Murzik");
        Cat barsik = new Cat("Barsik");
        bobik.run(500);
        bobik.swim(10);
        sharik.run(501);
        sharik.swim(11);
        murzik.run(200);
        murzik.swim(1);
        barsik.run(201);
        System.out.println("Dogs created: " + Dog.getDogsCount());
        System.out.println("Cats created: " + Cat.getCatsCount());
        System.out.println("Animals created: " + Animal.getAnimalCount());
    }
}
