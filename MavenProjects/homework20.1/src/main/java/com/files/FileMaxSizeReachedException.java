package com.files;

public class FileMaxSizeReachedException extends RuntimeException {
    private long maxFileSize;
    private long currentFileSize;
    private String filePath;

    public FileMaxSizeReachedException(String message, long maxFileSize, long currentFileSize, String filePath) {
        super(message);
        this.maxFileSize = maxFileSize;
        this.currentFileSize = currentFileSize;
        this.filePath = filePath;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public long getCurrentFileSize() {
        return currentFileSize;
    }

    public String getFilePath() {
        return filePath;
    }
}
