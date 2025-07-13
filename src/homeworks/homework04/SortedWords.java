package homeworks.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class SortedWords {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine().toLowerCase();
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                char[] chars = words[i].toCharArray();
                Arrays.sort(chars);;
                words[i] = new String(chars);
            }
            System.out.println(String.join(" ", words));
        }
    }
}
