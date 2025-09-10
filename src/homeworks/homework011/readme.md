# Домашнее задание 11

## Вывод консоли
```
 andrey@ZenbookINP  ~/git/java_first/dz_1/dz-one   main   /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64
/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/andrey/git/java_first/dz_1/dz-one/bin homeworks.h
omework011.Main 
Автомобили в базе:
Номер Модель Цвет Пробег Цена
a123me Mercedes White 0 8300000
b873of Volga Black 0 673000
w487mn Lexus Grey 76000 900000
p987hj Volga Red 610 704340
c987ss Toyota White 254000 761000
o983op Toyota Black 698000 740000
p146op BMW White 271000 850000
u893ii Toyota Purple 210900 440000
l097df Toyota Black 108000 780000
y876wd Toyota Black 160000 1000000
Автомобили с пробегом 0 и цветом Black: a123me b873of o983op l097df y876wd
Цвет автомобиля с минимальной стоимостью: Purple
```

## Класс Car
```java
package homeworks.homework011;

public class Car {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long cost;

    public Car(String number, String model, String color, long mileage, long cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public long getMileage() { return mileage; }
    public void setMileage(long mileage) { this.mileage = mileage; }

    public long getCost() { return cost; }
    public void setCost(long cost) { this.cost = cost; }

    @Override
    public String toString() {
        return number + " " + model + " " + color + " " + mileage + " " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage &&
                cost == car.cost &&
                java.util.Objects.equals(number, car.number) &&
                java.util.Objects.equals(model, car.model) &&
                java.util.Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(number, model, color, mileage, cost);
    }
}
```

## Класс Main
```java
package homeworks.homework011;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
            new Car("a123me", "Mercedes", "White", 0, 8300000),
            new Car("b873of", "Volga", "Black", 0, 673000),
            new Car("w487mn", "Lexus", "Grey", 76000, 900000),
            new Car("p987hj", "Volga", "Red", 610, 704340),
            new Car("c987ss", "Toyota", "White", 254000, 761000),
            new Car("o983op", "Toyota", "Black", 698000, 740000),
            new Car("p146op", "BMW", "White", 271000, 850000),
            new Car("u893ii", "Toyota", "Purple", 210900, 440000),
            new Car("l097df", "Toyota", "Black", 108000, 780000),
            new Car("y876wd", "Toyota", "Black", 160000, 1000000)
        );

        System.out.println("Автомобили в базе:");
        System.out.println("Номер Модель Цвет Пробег Цена");
        cars.forEach(System.out::println);

        String colorToFind = "Black";
        long mileageToFind = 0;
        Optional<String> filteredCarsNumbers = cars.stream()
            .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
            .map(Car::getNumber)
            .reduce((a, b) -> a + " " + b);
        if (filteredCarsNumbers.isPresent()) {
            System.out.println("Автомобили с пробегом " + mileageToFind + " и цветом " + colorToFind + ": " + filteredCarsNumbers.get());
        } else {
            System.out.println("Автомобили с пробегом " + mileageToFind + ": не найдены");
        }

        Optional<Car> minCostCar = cars.stream().min(Comparator.comparingLong(Car::getCost));
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + (minCostCar.isPresent() ? minCostCar.get().getColor() : "-"));
    }
}
```
