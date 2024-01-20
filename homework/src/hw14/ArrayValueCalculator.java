package hw14;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        int rowCount = array.length;
        int colCount = array[0].length;

        if (rowCount != 4 || colCount != 4) {
            throw new ArraySizeException("Array size should be 4x4");
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}
