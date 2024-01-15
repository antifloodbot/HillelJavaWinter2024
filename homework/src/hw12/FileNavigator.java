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
}

