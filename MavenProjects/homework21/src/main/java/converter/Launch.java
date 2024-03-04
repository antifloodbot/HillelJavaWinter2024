package converter;

public class Launch {
    public static void main(String[] args) {
        String directoryPath;
        if (args.length == 1) {
            directoryPath = args[0];
        } else {
            System.out.println("No directory selected. Current directory will be used.");
            directoryPath = System.getProperty("user.dir");
        }

        JsonToYamlConverter jsonToYamlConverter = new JsonToYamlConverter();
        String jsonToYamlResult = jsonToYamlConverter.scanAndConvert(directoryPath);
        System.out.println(jsonToYamlResult);

        YamlToJsonConverter yamlToJsonConverter = new YamlToJsonConverter();
        String yamlToJsonResult = yamlToJsonConverter.scanAndConvert(directoryPath);
        System.out.println(yamlToJsonResult);
    }
}
