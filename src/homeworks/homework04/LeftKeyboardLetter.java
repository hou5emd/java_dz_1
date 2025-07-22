package homeworks.homework04;

import java.util.Scanner;

public class LeftKeyboardLetter {
    private static final String keys = "qwertyuiopasdfghjklzxcvbnm";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите букву (q-z): ");
            char input = scanner.next().charAt(0);
            int idx = keys.indexOf(input);
            if (idx == -1) {
                System.out.println("Некорректный ввод");
            } else {
                char left = keys.charAt((idx - 1 + keys.length()) % keys.length());
                System.out.println(left);
            }
        }
    }
}
