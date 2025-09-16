package homeworks.homework012;

import java.io.*;
import java.text.ParseException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    "Введите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол возраст");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");
            try {
                if (parts.length < 7) {
                    throw new IllegalArgumentException("Введено меньше данных, чем требуется.");
                } else if (parts.length > 7) {
                    throw new IllegalArgumentException("Введено больше данных, чем требуется.");
                }
                Person person = Person.parse(parts);
                writePersonToFile(person);
                System.out.println("Данные успешно записаны.");
            } catch (IllegalArgumentException | ParseException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка при работе с файлом:");
                e.printStackTrace();
            }
        }
    }

    private static void writePersonToFile(Person person) throws IOException {
        String filename = "src/homeworks/homework012/" + person.getLastName() + ".csv";
        try (FileWriter fw = new FileWriter(filename, false)) {
            fw.write(person.toCsvString() + "\n");
        }
    }
}
