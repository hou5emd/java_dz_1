package homeworks.homework06;

import java.util.*;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Person> people = new ArrayList<>();
            List<Product> products = new ArrayList<>();

            System.out.println("Введите покупателей (имя и сумма денег через пробел, END для завершения):");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                String[] parts = line.trim().split(" ");
                if (parts.length != 2) {
                    System.out.println("Неверный ввод. Пример: Иван 100");
                    continue;
                }
                String name = parts[0];
                double money;
                try {
                    money = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Сумма денег должна быть числом");
                    continue;
                }
                try {
                    people.add(new Person(name, money));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Введите продукты (название и цена через пробел, END для завершения):");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                String[] parts = line.trim().split(" ");
                if (parts.length != 2) {
                    System.out.println("Неверный ввод. Пример: Хлеб 30");
                    continue;
                }
                String name = parts[0];
                double price;
                try {
                    price = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Цена должна быть числом");
                    continue;
                }
                try {
                    products.add(new Product(name, price));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Покупки. Вводите имя покупателя и название продукта через пробел, END для завершения:");
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                String[] parts = line.trim().split(" ");
                if (parts.length != 2) {
                    System.out.println("Неверный ввод. Пример: Иван Хлеб");
                    continue;
                }
                String personName = parts[0];
                String productName = parts[1];
                Person person = null;
                Product product = null;
                for (Person p : people) {
                    if (p.getName().equals(personName)) {
                        person = p;
                        break;
                    }
                }
                for (Product pr : products) {
                    if (pr.getName().equals(productName)) {
                        product = pr;
                        break;
                    }
                }
                if (person == null) {
                    System.out.println("Покупатель не найден");
                    continue;
                }
                if (product == null) {
                    System.out.println("Продукт не найден");
                    continue;
                }
                if (!person.buyProduct(product)) {
                    System.out.printf("%s не может позволить себе %s\n", person.getName(), product.getName());
                }
            }

            System.out.println("\nРезультаты покупок:");
            for (Person p : people) {
                System.out.println(p);
            }
        }
    }
}
