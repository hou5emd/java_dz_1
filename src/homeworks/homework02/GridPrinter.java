package homeworks.homework02;

import java.util.Scanner;

public class GridPrinter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число строк и столбцов сетки: ");
            int n = scanner.nextInt();
            System.out.print("Введите повторяемый элемент сетки: ");
            String element = scanner.next();

            System.out.println("Сетка по запросу " + n + " на " + n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }
}
