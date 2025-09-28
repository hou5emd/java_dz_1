package homeworks.homework06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void productWithoutName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Product(name, 1));
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
