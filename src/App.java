import java.util.Scanner;
import java.util.Arrays;

import homeworks.homework05.Television;

public class App {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);) {
            Television[] tvs = new Television[10];

            for (int i = 0; i < tvs.length; i++) {
                tvs[i] = new Television();
            }

            System.out.print("Введите максимальное допустимое значение громкости (от 50 до 70): ");
            int maxVolume = Integer.parseInt(scanner.nextLine());

            System.out.println("\nВключённые телевизоры с громкостью <= " + maxVolume + ":");
            for (Television tv : tvs) {
                if (tv.isOn() && tv.getVolume() <= maxVolume) {
                    System.out.println(tv);
                }
            }

            Arrays.sort(tvs, (a, b) -> Integer.compare(a.getChannel(), b.getChannel()));
            System.out.println("\nТелевизоры, отсортированные по номеру канала:");
            for (Television tv : tvs) {
                System.out.println(tv);
            }
        }
    }
}
