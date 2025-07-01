package homeworks.homework02;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите степень в градусах Фаренгейта: ");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.printf("%.1f градусов по Фаренгейту равна %.1f по Цельсию\n", fahrenheit, celsius);
        }
    }
}
