package homeworks.homework07;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private double discount;
    private LocalDate discountEndDate;

    public DiscountProduct(String name, double price, double discount, LocalDate discountEndDate) {
        super(name, price);
        if (discount < 0 || discount >= price) {
            throw new IllegalArgumentException("Скидка должна быть положительной и меньше цены");
        }
        if (discountEndDate == null) {
            throw new IllegalArgumentException("Дата окончания скидки не может быть null");
        }
        this.discount = discount;
        this.discountEndDate = discountEndDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount >= getPrice()) {
            throw new IllegalArgumentException("Скидка должна быть положительной и меньше цены");
        }
        this.discount = discount;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        if (discountEndDate == null) {
            throw new IllegalArgumentException("Дата окончания скидки не может быть null");
        }
        this.discountEndDate = discountEndDate;
    }

    public double getDiscountedPrice() {
        if (LocalDate.now().isAfter(discountEndDate)) {
            // Скидка истекла, возвращаем обычную цену
            return getPrice();
        }
        return getPrice() - discount;
    }

    @Override
    public String toString() {
        return getName() + " (" + getDiscountedPrice() + ", скидка до " + discountEndDate + ")";
    }
}
