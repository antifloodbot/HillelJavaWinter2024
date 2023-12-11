package lesson_04.ex;

public class FloorFlatCalculate {
    public static void main(String[] args) {
        int apartmentNumber = 37;
        int apartmentsPerFloor = 4;
        int floorsPerEntrance = 9;

        int[] location = findApartment(apartmentNumber, apartmentsPerFloor, floorsPerEntrance);
        System.out.println("Apartment #" + apartmentNumber + " is located in the entrance #" + location[0] +
                " and floor #" + location[1]);
    }

    public static int[] findApartment(int apartmentNumber, int apartmentsPerFloor, int floorsPerEntrance) {
        int apartmentsPerEntrance = apartmentsPerFloor * floorsPerEntrance;
        int entrance = (apartmentNumber - 1) / apartmentsPerEntrance + 1;
        int floor = ((apartmentNumber - 1) % apartmentsPerEntrance) / apartmentsPerFloor + 1;
        return new int[] {entrance, floor};
    }
}
