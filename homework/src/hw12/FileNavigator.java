package hw12;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap = new HashMap<>();

    public void add(String path, FileData file) {
        if (!fileMap.containsKey(path)) {
            fileMap.put(path, new ArrayList<>());
        }
        fileMap.get(path).add(file);
    }

    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : fileMap.values()) {
            for (FileData file : files) {
                if (file.getSizeInBytes() <= maxSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> files : fileMap.values()) {
            allFiles.addAll(files);
        }
        allFiles.sort(Comparator.comparingLong(FileData::getSizeInBytes));
        return allFiles;
    }

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

