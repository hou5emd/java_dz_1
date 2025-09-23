package test.homeworks.homework06;

import homeworks.homework06.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void productWithoutName() {
        assertThrows(IllegalArgumentException.class, () -> new Product("", 1));
    }

    @Test
    void productWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Кофе", -1));
    }

    @Test
    void productSetPrice() {
        Product product = new Product("Кофе", 0);
        product.setPrice(1);
        assertEquals(1, product.getPrice());
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(-1));
    }


}
