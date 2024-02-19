package com.files;

public class FileLogger {
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

    protected void log(String message) throws FileMaxSizeReachedException {
        logFileService.log(message, filePath, maxFileSize);
    }

    private void createLogFile() {
        logFileService.createLogFile(filePath);
    }
}
