package hw10;

public class Main {
    public static void main(String[] args) {
        CollectionNewImpl collection1 = new CollectionNewImpl();
        collection1.add("One");
        collection1.add("Three");
        collection1.add(1,"Two");

        System.out.println("'collection1' after adding three elements:\n" + collection1);

        collection1.delete("One");
        System.out.println("\n'collection1' after deleting string 'One':\n" + collection1);

        System.out.println("\nGetting index of 1:\n" + collection1.get(1));

        System.out.println("\n'collection1' contains string 'Two':\n" + collection1.contain("Two"));

        CollectionNewImpl collection2 = new CollectionNewImpl();
        System.out.println("\n'collection2' after creation:\n" + collection2);
        System.out.println("\nCompare 'collection1' with 'collection2' if they are equal:\n" + collection1.equals(collection2));

        System.out.println("\nGetting size of the 'collection1':\n" + collection1.size());

        collection1.clear();
        System.out.println("\n'collection1' after clear method:\n" + collection1);

        System.out.println("\nCompare 'collection1' with 'collection2' if they are equal:\n" + collection1.equals(collection2));
    }
}
