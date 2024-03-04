package converter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import converter.exceptions.DirectoryNotFoundError;
import converter.exceptions.IOError;

public class YamlToJsonConverter implements ConversionService {

    @Override
    public String scanAndConvert(String directoryPath) {
        File directory = new File(directoryPath);
        StringBuilder resultLog = new StringBuilder();

        if (!directory.exists() || !directory.isDirectory()) {
            throw new DirectoryNotFoundError("Specified path is not a directory.");
        }

        File convertedDirectory = new File(directory.getParent() + File.separator + "converted");
        if (!convertedDirectory.exists()) {
            convertedDirectory.mkdirs();
        }

        File resultLogFile = new File(convertedDirectory.getAbsolutePath() + File.separator + "result.log");

        try {
            if (!resultLogFile.exists()) {
                resultLogFile.createNewFile();
            }
        } catch (IOException e) {
            throw new IOError("Error creating result log file: " + e.getMessage());
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".yaml"));

        if (files == null || files.length == 0) {
            return "No YAML files found in the specified directory.";
        }

        for (File yamlFile : files) {
            try {
                String yamlStr = new String(Files.readAllBytes(Paths.get(yamlFile.getAbsolutePath())));
                String convertedJsonContent = convert(yamlStr);
                if (convertedJsonContent != null) {
                    String result = save(yamlFile, convertedJsonContent, resultLogFile);
                    resultLog.append(result).append("\n");
                } else {
                    resultLog.append("Conversion error: ").append(yamlFile.getName()).append("\n");
                    try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                        writer.write("Unable to convert file: " + yamlFile.getName() + "\n");
                    }
                }
            } catch (IOException e) {
                throw new IOError("Error reading/writing files: " + e.getMessage());
            } catch (Exception e) {
                resultLog.append("Conversion error: ").append(yamlFile.getName()).append("\n");
                try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                    writer.write("Unable to convert file: " + yamlFile.getName() + "\n");
                } catch (IOException ex) {
                    throw new IOError("Error writing to result log file: " + ex.getMessage());
                }
            }
        }

        return "Conversion results saved in result.log file.";
    }

    @Override
    public String convert(String yamlStr) {
        try {
            ObjectMapper yamlReader = new ObjectMapper(new YAMLMapper().getFactory());
            Object obj = yamlReader.readValue(yamlStr, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();
            return jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            throw new IOError("Error converting YAML to JSON: " + e.getMessage());
        }
    }

    @Override
    public String save(File yamlFile, String jsonContent, File resultLogFile) {
        try {
            String fileNameWithoutExtension = yamlFile.getName().replaceFirst("[.][^.]+$", "");
            String jsonFilePath = yamlFile.getParent() + File.separator + "converted";

            File directory = new File(jsonFilePath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            jsonFilePath += File.separator + fileNameWithoutExtension + "_converted.json";
            File jsonFile = new File(jsonFilePath);
            jsonFile.createNewFile();

            try (FileWriter writer = new FileWriter(jsonFile)) {
                writer.write(jsonContent);
            }

            long oldSize = yamlFile.length();
            long newSize = jsonFile.length();
            long duration = System.currentTimeMillis() - Files.getLastModifiedTime(Paths.get(yamlFile.getAbsolutePath())).toMillis();

            String log = String.format("%s -> %s, %dms, %dbytes -> %dbytes", yamlFile.getName(), jsonFile.getName(), duration, oldSize, newSize);

            try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                writer.write(log + "\n");
            }

            return log;
        } catch (IOException e) {
            String log = String.format("Unable to convert file: %s%n", yamlFile.getName());
            try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                writer.write(log);
            } catch (IOException ex) {
                throw new IOError("Error writing error log: " + ex.getMessage());
            }
            throw new IOError("Error saving JSON file: " + e.getMessage());
        }
    }

}
