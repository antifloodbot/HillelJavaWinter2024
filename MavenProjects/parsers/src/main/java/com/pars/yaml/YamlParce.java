package com.pars.yaml;

import com.pars.ReadFromFile;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class YamlParce {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        String yamlStr = ReadFromFile.readToString("MavenProjects/parsers/src/main/resources/user.yaml");
        Map<String, Object> obj = yaml.load(yamlStr);
//        System.out.println(obj);
        System.out.println(yaml.dump(obj));
    }
}