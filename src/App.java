import java.util.Scanner;
import homeworks.homework03.Television;

public class App {
    public static void main(String[] args) {
        Television tv1 = new Television("Samsung", 55, true, 30, 5);
        Television tv2 = new Television("LG", 42, false, 15, 10);
        Television tv3 = new Television();

        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите бренд: ");
            String brand = scanner.nextLine();
            System.out.print("Введите размер (дюймы): ");
            int size = scanner.nextInt();
            System.out.print("Смарт ТВ? (true/false): ");
            boolean isSmart = scanner.nextBoolean();
            System.out.print("Громкость (0-100): ");
            int volume = scanner.nextInt();
            System.out.print("Канал (1-99): ");
            int channel = scanner.nextInt();
            Television userTV = new Television(brand, size, isSmart, volume, channel);
            System.out.println("Ваш телевизор: " + userTV);
        }
    }
}
