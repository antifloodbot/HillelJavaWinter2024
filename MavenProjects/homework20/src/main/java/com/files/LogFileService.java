package com.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogFileService {
    public void log(String message, String filePath, long maxFileSize) throws FileMaxSizeReachedException {
        File file = new File(filePath);

        if (file.exists() && file.length() + message.length() > maxFileSize) {
            String newFilePath = generateNewFilePath();
            file = new File(newFilePath);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new FileMaxSizeReachedException("Failed to write to log file", 0, maxFileSize, e.getMessage());
        }
    }

    public void createLogFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Failed to create log file: " + e.getMessage());
            }
        }
    }

    private String generateNewFilePath() {
        return "";
    }
}
