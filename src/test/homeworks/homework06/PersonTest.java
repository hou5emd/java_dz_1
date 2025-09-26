package test.homeworks.homework06;

import homeworks.homework06.Person;
import homeworks.homework06.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class PersonTest {

    static ArrayList<Product> products;
    static Double allProductsPrice;

    @BeforeAll
    static void setup() {
        products = new ArrayList<>(Arrays.asList(new Product("Кофе", 100), new Product("Хлеб", 50)));

        allProductsPrice = products.stream().map((Product::getPrice)).reduce(0.0, Double::sum);
    }

    @Test
    void withoutName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", 10));
    }

    @Test
    void negativeMoney() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Вася", -1));
    }

    @Test
    void moneyCount() {
        Person person = new Person("Test", allProductsPrice * 2);
        products.forEach((person::buyProduct));
        assertEquals(allProductsPrice, person.getMoney());
    }

    @Test
    void buyProducts() {
        Person person = new Person("Test", allProductsPrice * 2);
        products.forEach((person::buyProduct));
        assertEquals(products, person.getBag());
    }

    @Test
    void notEnoughMoney() {
        Person person = new Person("Test", allProductsPrice - 1);
        products.forEach((person::buyProduct));
        assertEquals(1, person.getBag().size());
    }

    @Disabled
    @Test
    void disabledTest() {
        // If this test Enabled, it won't pass
        assertThrows(IllegalArgumentException.class, () -> new Person("Вася", 1));
    }

    @Test
    void setMoney() {
        Person person = new Person("Вася", 0);
        person.setMoney(1);
        assertEquals(1, person.getMoney());
        assertThrows(IllegalArgumentException.class, () -> person.setMoney(-1));
    }

    @Test
    void setName() {
        Person person = new Person("Вася", 0);
        person.setName("Валера");
        assertEquals("Валера", person.getName());
        assertThrows(IllegalArgumentException.class, () -> person.setName(""));
    }

    @AfterAll
    static void dispose() {
        products = null;
        allProductsPrice = null;
    }
}
