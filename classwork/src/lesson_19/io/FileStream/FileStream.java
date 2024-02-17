package lesson_19.io.FileStream;

import java.io.*;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class FileStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream =
                new FileInputStream("/Users/ktalamaniuk/IdeaProjects/HillelJavaWinter2024/classwork/src/lesson_19/io/FileStream/input.txt");
        int size = inputStream.available();
        System.out.println("file size: " + size);
        for (int i = 0; i < size; i++) {
            System.out.print((char) inputStream.read());
        }
        inputStream.close();

        OutputStream outputStream =
                new FileOutputStream("/Users/ktalamaniuk/IdeaProjects/HillelJavaWinter2024/classwork/src/lesson_19/io/FileStream/output.txt");
        String str = "Costa Da Gama";
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }
}
