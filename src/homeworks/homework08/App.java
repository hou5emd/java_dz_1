package homeworks.homework08;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> purchaseResults = new ArrayList<>();
        String inputPath = "src/homeworks/homework08/input.txt";
        String outputPath = "src/homeworks/homework08/output.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;

            line = reader.readLine();
            if (line != null) {
                String[] personParts = line.split("; ?");
                for (String part : personParts) {
                    String[] nameMoney = part.split(" = ");
                    if (nameMoney.length == 2) {
                        String name = nameMoney[0].trim();
                        double money = Double.parseDouble(nameMoney[1].trim());
                        people.add(new Person(name, money));
                    }
                }
            }

            line = reader.readLine();
            if (line != null) {
                String[] productParts = line.split("; ?");
                for (String part : productParts) {
                    String[] namePrice = part.split(" = ");
                    if (namePrice.length == 2) {
                        String name = namePrice[0].trim();
                        double price = Double.parseDouble(namePrice[1].trim());
                        products.add(new Product(name, price));
                    }
                }
            }

            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("END"))
                    break;
                String[] parts = line.trim().split(" ");
                if (parts.length < 2)
                    continue;
                String personName = parts[0] + (parts.length > 2 ? " " + parts[1] : "");
                String productName = parts.length > 2 ? parts[2] : parts[1];
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
                if (person == null || product == null)
                    continue;
                if (person.buyProduct(product)) {
                    purchaseResults.add(person.getName() + " купил(а) " + product.getName());
                } else {
                    purchaseResults.add(
                            person.getName() + " не может позволить себе " + product.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            for (String result : purchaseResults) {
                writer.println(result);
            }
            for (Person p : people) {
                writer.println(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
