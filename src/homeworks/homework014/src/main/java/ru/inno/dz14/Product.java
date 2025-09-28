package homeworks.homework014.src.main.java.ru.inno.dz14;


import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (price < 0) {
            throw new IllegalArgumentException(
                    "Стоимость продукта не может быть отрицательным числом");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                    "Стоимость продукта не может быть отрицательным числом");
        }
        this.price = price;
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
