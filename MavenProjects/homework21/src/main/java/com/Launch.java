package com;

import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Введіть шлях до папки, де знаходиться файл з розширенням .json");

            // Очікуємо введення користувача з консолі
            Scanner scanner = new Scanner(System.in);
            String directoryPath = scanner.nextLine();

            // Створення об'єкту класу JsonToYamlConverter
            JsonToYamlConverter converter = new JsonToYamlConverter();

            // Виклик методу scanAndConvertJsonToYaml для сканування та конвертації JSON у YAML
            String result = converter.scanAndConvertJsonToYaml(directoryPath);

            // Виведення результату у консоль
            System.out.println(result);
        }
    }
}
