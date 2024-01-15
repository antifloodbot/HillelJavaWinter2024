package hw12;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        FileData file1 = new FileData("file1.txt", 1024, "/path/to/file1.txt");
        FileData file2 = new FileData("file2.txt", 2048, "/path/to/file2.txt");
        FileData file3 = new FileData("file3.txt", 512, "/path/to/another/file3.txt");

        navigator.add("/path/to", file1);
        navigator.add("/path/to", file2);
        navigator.add("/path/to/another", file3);

        System.out.println("Files in /path/to:");
        List<FileData> filesAtPath = navigator.find("/path/to");
        for (FileData file : filesAtPath) {
            System.out.println(file);
        }

        System.out.println("\nFiltered by size (maxSize=1500):");
        List<FileData> filteredFiles = navigator.filterBySize(1500);
        for (FileData file : filteredFiles) {
            System.out.println(file);
        }

        System.out.println("\nAll files sorted by size:");
        List<FileData> sortedFiles = navigator.sortBySize();
        for (FileData file : sortedFiles) {
            System.out.println(file);
        }

        navigator.remove("/path/to");
        System.out.println("\nFiles in /path/to after removal:");
        filesAtPath = navigator.find("/path/to");
        for (FileData file : filesAtPath) {
            System.out.println(file);
        }
    }
}
