package homeworks.homework02;

import java.util.Scanner;

public class StringRepeater {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Исходная строка: ");
            String str = scanner.nextLine();
            System.out.print("Сколько раз вывести строку? ");
            int count = scanner.nextInt();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                result.append(str);
            }
            System.out.println("После повторения " + count + " раз: " + result);
        }
    }
}
