package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonToYamlConverter {
    public String scanAndConvertJsonToYaml(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            return "Введений шлях не відповідає директорії";
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null || files.length == 0) {
            return "У вказаній директорії відсутні файли з розширенням .json";
        }

        File jsonFile = files[0];
        String jsonStr;
        try {
            jsonStr = new String(Files.readAllBytes(Paths.get(jsonFile.getAbsolutePath())));
            return convertJsonToYaml(jsonStr);
        } catch (IOException e) {
            return "Помилка читання файлу: " + e.getMessage();
        }
    }

    private String convertJsonToYaml(String jsonStr) {
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonStr);

            Gson gson = new Gson();
            JsonNode jsonNode = new ObjectMapper().readTree(gson.toJson(jsonElement));

            YAMLMapper yamlMapper = new YAMLMapper();

            return yamlMapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
