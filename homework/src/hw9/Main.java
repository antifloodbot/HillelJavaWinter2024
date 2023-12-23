package hw9;

public class Main {
    public static void main(String[] args) {
        StringCollectionService collectionService = new StringCollectionService();
        collectionService.add("One");
        collectionService.add("Two");
        collectionService.add("Three");

        collectionService.add(0, "OneOne");
        collectionService.add("Olala");
        collectionService.delete(4);
        collectionService.delete("OneOne");

        System.out.println(collectionService.get(2));
        collectionService.printCollection();
    }
}
