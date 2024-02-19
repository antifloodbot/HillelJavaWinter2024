package com.files;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class FileLoggerTest {

    private Object PowerMockito;

    @Test
    void debug_LogsDebugMessage_WhenDebugLevelIsIncluded() {
        String filePath = "test_debug.log";
        LoggingLevel level = LoggingLevel.DEBUG;
        long maxFileSize = 1024;
        FileLogger logger = new FileLogger(filePath, level, maxFileSize);

        assertDoesNotThrow(() -> logger.debug("Debug message"));
        File logFile = new File(filePath);
        assertTrue(logFile.exists());
    }

    @Test
    void info_LogsInfoMessage_WhenInfoLevelIsIncluded() {
        String filePath = "test_info.log";
        LoggingLevel level = LoggingLevel.INFO;
        long maxFileSize = 1024;
        FileLogger logger = new FileLogger(filePath, level, maxFileSize);

        assertDoesNotThrow(() -> logger.info("Info message"));
        File logFile = new File(filePath);
        assertTrue(logFile.exists());
    }

    @Test
    void debug_DoesNotThrowException_WhenFileSizeIsBelowMax() {
        String filePath = "test_debug.log";
        LoggingLevel level = LoggingLevel.DEBUG;
        long maxFileSize = 1024;
        FileLogger logger = new FileLogger(filePath, level, maxFileSize);

        assertDoesNotThrow(() -> logger.debug("Debug message"));
    }

    @Test
    void info_DoesNotThrowException_WhenInfoLevelIsIncluded() {
        String filePath = "test_info.log";
        LoggingLevel level = LoggingLevel.INFO;
        long maxFileSize = 1024;
        FileLogger logger = new FileLogger(filePath, level, maxFileSize);

        assertDoesNotThrow(() -> logger.info("Test message"));
    }

    @Test
    void log_WritesMessageToFile() throws IOException {
        String filePath = "test_log.txt";
        LoggingLevel level = LoggingLevel.DEBUG;
        long maxFileSize = 1024;
        String message = "Test log message";
        FileLogger logger = new FileLogger(filePath, level, maxFileSize);
        logger.log(message);

        assertTrue(Files.exists(Paths.get(filePath)), "Log file was not created");
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        assertTrue(content.contains(message), "Log file does not contain the logged message");
    }
}