package com.files;

import java.io.InputStream;
import java.util.Scanner;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(InputStream inputStream) {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");

            if (parts.length != 2) {
                System.err.println("Invalid configuration line: " + line);
                continue;
            }

            String key = parts[0].trim();
            String value = parts[1].trim();

            switch (key) {
                case "FILE":
                    configuration.setFilePath(value);
                    break;
                case "LEVEL":
                    configuration.setLevel(LoggingLevel.valueOf(value));
                    break;
                case "MAX-SIZE":
                    configuration.setMaxFileSize(Long.parseLong(value));
                    break;
                case "FORMAT":
                    configuration.setFormat(value);
                    break;
                default:
                    System.err.println("Unknown configuration key: " + key);
            }
        }
        scanner.close();

        return configuration;
    }
}


