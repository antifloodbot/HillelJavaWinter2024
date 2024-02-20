package com.files;

public class FileLogger implements Logger {
    private String filePath;
    private LoggingLevel level;
    private long maxFileSize;
    private LogFileService logFileService;

    public FileLogger(String filePath, LoggingLevel level, long maxFileSize) {
        this.filePath = filePath;
        this.level = level;
        this.maxFileSize = maxFileSize;
        this.logFileService = new LogFileService();
        createLogFile();
    }

    @Override
    public void debug(String message) {
        if (level.includes(LoggingLevel.DEBUG)) {
            log("[DEBUG] " + message);
        }
    }

    @Override
    public void info(String message) {
        if (level.includes(LoggingLevel.INFO)) {
            log("[INFO] " + message);
        }
    }

    @Override
    public void error(String message) {
        log("[ERROR] " + message);
    }

    protected void log(String message) {
        try {
            logFileService.log(message, filePath, maxFileSize);
        } catch (FileMaxSizeReachedException e) {
            System.err.println("Failed to log message: " + e.getMessage());
        }
    }

    private void createLogFile() {
        logFileService.createLogFile(filePath);
    }
}
