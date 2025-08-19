package homeworks.homework08;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> purchases = new ArrayList<>();

    public Person(String name, double money) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Сумма денег не может быть отрицательной");
        }
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public boolean buyProduct(Product product) {
        double price = product.getPrice();
        if (money >= price) {
            money -= price;
            purchases.add(product);
            return true;
        }
        return false;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ");
        if (purchases.isEmpty()) {
            sb.append("Ничего не куплено");
        } else {
            for (int i = 0; i < purchases.size(); i++) {
                sb.append(purchases.get(i).getName());
                if (i < purchases.size() - 1)
                    sb.append(", ");
            }
        }
        return sb.toString();
    }
}
