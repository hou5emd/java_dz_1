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
