package hw14;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();

        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "7", "7", "8"},
                {"9", "10", "11", "hello"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = calculator.doCalc(validArray);
            System.out.println("Calculation result for valid array: " + result);
        } catch (ArraySizeException e) {
            System.out.println("Error in array size: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("Error in array data: " + e.getMessage());
        }

        try {
            int result = calculator.doCalc(invalidSizeArray);
            System.out.println("Calculation result for invalid size array: " + result);
        } catch (ArraySizeException e) {
            System.err.println("Error in array size: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("Error in array data: " + e.getMessage());
        }

        try {
            int result = calculator.doCalc(invalidDataArray);
            System.out.println("Calculation result for valid array: " + result);
        } catch (ArraySizeException e) {
            System.err.println("Error in array size: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("Error in array data: " + e.getMessage());
        }
    }
}
