package converter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import converter.exceptions.DirectoryNotFoundError;
import converter.exceptions.IOError;
import converter.exceptions.JsonSyntaxError;

public class JsonToYamlConverter implements ConversionService {

    @Override
    public String scanAndConvert(String directoryPath) {
        File directory = new File(directoryPath);
        StringBuilder resultLog = new StringBuilder();

        if (!directory.exists() || !directory.isDirectory()) {
            throw new DirectoryNotFoundError("Specified path is not a directory.");
        }

        File convertedDirectory = new File(directory.getAbsolutePath() + File.separator + "converted");
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

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null || files.length == 0) {
            return "No JSON files found in the specified directory.";
        }

        for (File jsonFile : files) {
            try {
                String jsonStr = new String(Files.readAllBytes(Paths.get(jsonFile.getAbsolutePath())));
                String convertedYamlContent = convert(jsonStr);
                if (convertedYamlContent != null) {
                    String result = save(jsonFile, convertedYamlContent, resultLogFile);
                    resultLog.append(result).append("\n");
                } else {
                    resultLog.append("Conversion error: ").append(jsonFile.getName()).append("\n");
                    try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                        writer.write("Unable to convert file: " + jsonFile.getName() + "\n");
                    }
                }
            } catch (IOException e) {
                throw new IOError("Error reading/writing files: " + e.getMessage());
            } catch (JsonSyntaxError e) {
                resultLog.append("Conversion error: ").append(jsonFile.getName()).append("\n");
                try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                    writer.write("Unable to convert file: " + jsonFile.getName() + "\n");
                } catch (IOException ex) {
                    throw new IOError("Error writing to result log file: " + ex.getMessage());
                }
            }
        }

        return "Conversion results saved in result.log file.";
    }

    @Override
    public String convert(String jsonStr) {
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonStr);
            Gson gson = new Gson();
            JsonNode jsonNode = new ObjectMapper().readTree(gson.toJson(jsonElement));
            YAMLMapper yamlMapper = new YAMLMapper();
            return yamlMapper.writeValueAsString(jsonNode);
        } catch (IOException e) {
            throw new IOError("Error converting JSON to YAML: " + e.getMessage());
        } catch (Exception e) {
            throw new JsonSyntaxError("Error parsing JSON: " + e.getMessage());
        }
    }

    @Override
    public String save(File jsonFile, String yamlContent, File resultLogFile) {
        try {
            String fileNameWithoutExtension = jsonFile.getName().replaceFirst("[.][^.]+$", "");
            String yamlFilePath = jsonFile.getParent() + File.separator + "converted";

            File directory = new File(yamlFilePath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            yamlFilePath += File.separator + fileNameWithoutExtension + "_converted.yaml";
            File yamlFile = new File(yamlFilePath);
            yamlFile.createNewFile();

            yamlContent = yamlContent.replaceFirst("^---\\n", "");

            try (FileWriter writer = new FileWriter(yamlFile)) {
                writer.write(yamlContent);
            }

            long oldSize = jsonFile.length();
            long newSize = yamlFile.length();
            long duration = System.currentTimeMillis() - Files.getLastModifiedTime(Paths.get(jsonFile.getAbsolutePath())).toMillis();

            String log = String.format("%s -> %s, %dms, %dbytes -> %dbytes", jsonFile.getName(), yamlFile.getName(), duration, oldSize, newSize);

            try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                writer.write(log + "\n");
            }

            return log;
        } catch (IOException e) {
            String log = String.format("Unable to convert file: %s%n", jsonFile.getName());
            try (FileWriter writer = new FileWriter(resultLogFile, true)) {
                writer.write(log);
            } catch (IOException ex) {
                throw new IOError("Error writing error log: " + ex.getMessage());
            }
            throw new IOError("Error saving YAML file: " + e.getMessage());
        }
    }

}
