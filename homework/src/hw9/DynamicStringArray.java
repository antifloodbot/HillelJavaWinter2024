package hw9;

public class DynamicStringArray {
    private String[] array;
    private int size;

    public DynamicStringArray() {
        array = new String[10];
        size = 0;
    }

    public boolean add(int index, String value) {
        if (index > size || index < 0) {
            return false;
        }
        if (size == array.length) {
            String[] newArray = new String[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
        return true;
    }

    public boolean add(String value) {
        if (size == array.length) {
            String[] newArray = new String[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
        return true;
    }

    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return true;
    }

    public boolean delete(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("dynamicArray: {");
        for (int i = 0; i < size; i++) {
            sb.append("\"").append(array[i]).append("\"");
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
