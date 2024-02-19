package com.files;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private String filePath;
    private LoggingLevel level;
    private long maxFileSize;

    public FileLogger(String filePath, LoggingLevel level, long maxFileSize) {
        this.filePath = filePath;
        this.level = level;
        this.maxFileSize = maxFileSize;
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        if (level.includes(LoggingLevel.DEBUG)) {
            log("[DEBUG] " + message);
        }
    }

    public void info(String message) throws FileMaxSizeReachedException {
        if (level.includes(LoggingLevel.INFO)) {
            log("[INFO] " + message);
        }
    }

    public void log(String message) throws FileMaxSizeReachedException {
        File file = new File(filePath);

        if (file.exists() && file.length() + message.length() > maxFileSize) {
            String newFilePath = generateNewFilePath();
            file = new File(newFilePath);
            this.filePath = newFilePath;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(message);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    private String generateNewFilePath() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
        String timestamp = sdf.format(new Date());
        String fileName = "Log_" + timestamp + ".txt";
        return fileName;
    }
}









