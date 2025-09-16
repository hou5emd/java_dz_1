# Домашнее задание: 13

## Вывод консоли
```
 andrey@ZenbookINP  ~/git/java_first/dz_1/dz-one   homeworks/homework013   /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/andrey/git/java_first/dz_1/dz-one/bi
n homeworks.homework013.TestInputFormatter 
parseCount("123"): 123
parseCount("abc"): Невалидное значение
validateCount("456"): 456
Невалидное значение
validateCount("xyz"): null
parseNumber("3.14"): 3.14
parseNumber("notANumber"): Невалидное значение
validateNumber("2.718"): 2.718
Невалидное значение
validateNumber("bad"): null
```
## InputFormatter.java
```java
package homeworks.homework013.utils;

public class InputFormatter {
    public static Integer parseCount(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    public static Integer validateCount(String value) {
        try {
            return parseCount(value);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Double parseNumber(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    public static Double validateNumber(String value) {
        try {
            return parseNumber(value);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
```

## TestInputFormatter.java
```java
package homeworks.homework013;

import homeworks.homework013.utils.InputFormatter;

public class TestInputFormatter {
    public static void main(String[] args) {
        System.out.println("parseCount(\"123\"): " + InputFormatter.parseCount("123"));
        try {
            InputFormatter.parseCount("abc");
        } catch (Exception e) {
            System.out.println("parseCount(\"abc\"): " + e.getMessage());
        }

        System.out.println("validateCount(\"456\"): " + InputFormatter.validateCount("456"));
        System.out.println("validateCount(\"xyz\"): " + InputFormatter.validateCount("xyz"));

        System.out.println("parseNumber(\"3.14\"): " + InputFormatter.parseNumber("3.14"));
        try {
            InputFormatter.parseNumber("notANumber");
        } catch (Exception e) {
            System.out.println("parseNumber(\"notANumber\"): " + e.getMessage());
        }

        System.out.println("validateNumber(\"2.718\"): " + InputFormatter.validateNumber("2.718"));
        System.out.println("validateNumber(\"bad\"): " + InputFormatter.validateNumber("bad"));
    }
}
```
