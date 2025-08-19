package homeworks.homework08;

import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (name.matches("\\d+")) {
            throw new IllegalArgumentException("Название не должно содержать только цифры");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Название должно быть не короче 3 символов");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Стоимость продукта должна быть больше нуля");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }

    @Override
    public boolean equals(Object input) {
        if (this == input)
            return true;
        if (input == null || getClass() != input.getClass())
            return false;
        Product product = (Product) input;
        return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
