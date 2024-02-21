package com.files;

public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean includes(LoggingLevel otherLevel) {
        return this.ordinal() >= otherLevel.ordinal();
    }
}
