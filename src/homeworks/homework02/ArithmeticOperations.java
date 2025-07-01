package homeworks.homework02;

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите 1-е целое число: ");
            int a = scanner.nextInt();
            System.out.print("Введите второе целое число: ");
            int b = scanner.nextInt();

            int sum = a + b;
            int diff = a - b;
            int prod = a * b;
            double avg = (a + b) / 2.0;
            int distance = Math.abs(a - b);
            int max = Math.max(a, b);
            int min = Math.min(a, b);

            System.out.println("Сумма двух целых чисел: " + sum);
            System.out.println("Разница двух целых чисел: " + diff);
            System.out.println("Произведение из двух целых чисел: " + prod);
            System.out.printf("Среднее из двух целых чисел: %.2f\n", avg);
            System.out.println("Расстояние двух целых чисел: " + distance);
            System.out.println("Максимальное целое число: " + max);
            System.out.println("Минимальное целое число: " + min);
        }
    }
}
