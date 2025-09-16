# Домашнее задание: 12

## Вывод консоли
```
 andrey@ZenbookINP  ~/git/java_first/dz_1/dz-one   homeworks/homework012   /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/andrey/git/java_first/dz_1/dz-one/bin homeworks.homework012.Main
Введите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол возраст
Андросов Андрей Андреевич 19.11.19922                                                                              
Ошибка: Введено меньше данных, чем требуется.
 andrey@ZenbookINP  ~/git/java_first/dz_1/dz-one   homeworks/homework012   /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/andrey/git/java_first/dz_1/dz-one/bin homeworks.homework012.Main
Введите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол возраст
Андросов Андрей Андреевич 19.11.1991 +790909643111 m 32        
Данные успешно записаны.
```

## Main.java
```java
package homeworks.homework012;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол возраст");
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
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(person.toCsvString() + "\n");
        }
    }
}
```

---

## Person.java
```java
package homeworks.homework012;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;
    private int age;

    public Person(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public static Person parse(String[] parts) throws ParseException {
        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];
        String birthDate = parts[3];
        String phoneStr = parts[4];
        String genderStr = parts[5];
        String ageStr = parts[6];

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(birthDate);
        } catch (ParseException e) {
            throw new ParseException("Неверный формат даты рождения. Ожидается dd.MM.yyyy", 0);
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseUnsignedLong(phoneStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое беззнаковое число.");
        }

        if (genderStr.length() != 1 || !(genderStr.equalsIgnoreCase("f") || genderStr.equalsIgnoreCase("m"))) {
            throw new IllegalArgumentException("Пол должен быть символом 'f' или 'm'.");
        }
        char gender = genderStr.charAt(0);

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Возраст должен быть целым числом.");
        }

        return new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender, age);
    }

    public String getLastName() {
        return lastName;
    }

    public String toCsvString() {
        return lastName + "," + firstName + "," + middleName + "," + birthDate + "," + phoneNumber + "," + gender + "," + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber &&
                gender == person.gender &&
                age == person.age &&
                lastName.equals(person.lastName) &&
                firstName.equals(person.firstName) &&
                middleName.equals(person.middleName) &&
                birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName, firstName, middleName, birthDate, phoneNumber, gender, age);
    }
}
```
