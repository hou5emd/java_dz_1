# Домашняя работа №14: написать тесты для homework06

## Ответы на вопросы
### Какие исключения ожидаются? Можно ли их избежать?
Ожидаем IllegalArgumentException, возникает в конструкторах и сеттерах классов Person и Product при передаче некорректных данных (пустое имя, отрицательное значение денег или цены). Избежать их можно, если заранее проверить данные.


## PersonTest.java

```java
package homeworks.homework06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class PersonTest {

    static ArrayList<Product> products;
    static Double allProductsPrice;

    @BeforeAll
    static void setup() {
        products =
                new ArrayList<>(Arrays.asList(new Product("Кофе", 100), new Product("Хлеб", 50)));

        allProductsPrice = products.stream().map((Product::getPrice)).reduce(0.0, Double::sum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void withoutName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Person(name, 10));
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
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void setNameError(String name) {
        Person person = new Person("Вася", 0);
        assertThrows(IllegalArgumentException.class, () -> person.setName(name));
    }

    @AfterAll
    static void dispose() {
        products = null;
        allProductsPrice = null;
    }
}
```

## ProductTest.java

```java
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
```