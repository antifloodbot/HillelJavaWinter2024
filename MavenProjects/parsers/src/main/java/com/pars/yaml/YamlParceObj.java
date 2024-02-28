package com.pars.yaml;

import com.pars.ReadFromFile;
import com.pars.UserExt;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlParceObj {
    public static void main(String[] args) {
        Yaml yaml = new Yaml(new Constructor(UserExt.class));
        String yamlStr = ReadFromFile.readToString("MavenProjects/parsers/src/main/resources/userClass.yaml");
        UserExt user = yaml.load(yamlStr);
        System.out.println(user);
    }
}
