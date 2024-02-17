package lesson_19.io.byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {

        try (
//                FileInputStream fis = new FileInputStream(
//                        "classwork/src/lesson_19/io/byteStream/input.txt");
//                FileOutputStream fos = new FileOutputStream(
//                        "classwork/src/lesson_19/io/byteStream/output.txt");

                FileInputStream fis = new FileInputStream(
                        "classwork/src/lesson_19/io/byteStream/picture.png"); // -> from
                FileOutputStream fos = new FileOutputStream(
                        "classwork/src/lesson_19/io/byteStream/picture_copy.png");
        ) {

            int a;
            while ((a = fis.read()) != -1) {
                fos.write(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
