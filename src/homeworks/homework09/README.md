# Домашнее задание: Инкапсуляция. Модификаторы доступа в Java

## Вывод из консоли

```
Toyota Corolla (2020): 120 л.с., ускорение 10, подвеска 15, долговечность 100
Ferrari 488 (2022): 1005 л.с., ускорение 8, подвеска 15, долговечность 90, Дополнения: [Turbo, Nitro]
Lamborghini Aventador (2021): 750 л.с., ускорение 7, подвеска 18, долговечность 80, Звёзды: 5
Обычная Гонка: City, Длина: 5000, Призовой фонд: 10000, Участников: 1
Драг Гонка: Highway, Длина: 1000, Призовой фонд: 15000, Участников: 1
Дрифт Гонка: Mountain, Длина: 3000, Призовой фонд: 12000, Участников: 1
Гараж содержит: 3 автомобилей
1) Toyota Corolla (2020): 120 л.с., ускорение 10, подвеска 15, долговечность 100
2) Ferrari 488 (2022): 1005 л.с., ускорение 8, подвеска 15, долговечность 90, Дополнения: [Turbo, Nitro]
3) Lamborghini Aventador (2021): 750 л.с., ускорение 7, подвеска 18, долговечность 80, Звёзды: 5

После замены автомобиля: Гараж содержит: 3 автомобилей
1) Honda Civic (2019): 110 л.с., ускорение 11, подвеска 14, долговечность 95
2) Ferrari 488 (2022): 1005 л.с., ускорение 8, подвеска 15, долговечность 90, Дополнения: [Turbo, Nitro]
3) Lamborghini Aventador (2021): 750 л.с., ускорение 7, подвеска 18, долговечность 80, Звёзды: 5
```

## Исходный код

### App.java
```java
package homeworks.homework09;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020, 120, 10, 15, 100);
        PerformanceCar perfCar = new PerformanceCar("Ferrari", "488", 2022, 670, 8, 20, 90,
                new String[] {"Turbo", "Nitro"});
        ShowCar showCar = new ShowCar("Lamborghini", "Aventador", 2021, 750, 7, 18, 80, 5);

        System.out.println(car1);
        System.out.println(perfCar);
        System.out.println(showCar);

        Race casual = new CasualRace(5000, "City", 10000);
        Race drag = new DragRace(1000, "Highway", 15000);
        Race drift = new DriftRace(3000, "Mountain", 12000);

        casual.addParticipant(car1);
        drag.addParticipant(perfCar);
        drift.addParticipant(showCar);

        System.out.println(casual);
        System.out.println(drag);
        System.out.println(drift);

        Garage garage = new Garage();
        garage.parkCar(car1);
        garage.parkCar(perfCar);
        garage.parkCar(showCar);
        System.out.println(garage);

        garage.modifyCar(0, new Car("Honda", "Civic", 2019, 110, 11, 14, 95));
        System.out.println("После замены автомобиля: " + garage);
    }
}
```

### Car.java
```java
package homeworks.homework09;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car() {}

    public Car(String brand, String model, int year, int horsepower, int acceleration,
            int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getHorsepower() { return horsepower; }
    public void setHorsepower(int horsepower) { this.horsepower = horsepower; }
    public int getAcceleration() { return acceleration; }
    public void setAcceleration(int acceleration) { this.acceleration = acceleration; }
    public int getSuspension() { return suspension; }
    public void setSuspension(int suspension) { this.suspension = suspension; }
    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    @Override
    public String toString() {
        return String.format("%s %s (%d): %d л.с., ускорение %d, подвеска %d, долговечность %d",
                brand, model, year, horsepower, acceleration, suspension, durability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return year == car.year && horsepower == car.horsepower && acceleration == car.acceleration
                && suspension == car.suspension && durability == car.durability
                && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, horsepower, acceleration, suspension, durability);
    }
}
```

### PerformanceCar.java
```java
package homeworks.homework09;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar() {
        super();
        this.addOns = new String[0];
    }

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration,
            int suspension, int durability, String[] addOns) {
        super(brand, model, year, (int) (horsepower * 1.5), acceleration, (int) (suspension * 0.75),
                durability);
        this.addOns = addOns != null ? addOns : new String[0];
    }

    public String[] getAddOns() { return addOns; }
    public void setAddOns(String[] addOns) { this.addOns = addOns; }

    @Override
    public String toString() {
        return super.toString() + ", Дополнения: " + Arrays.toString(addOns);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }
}
```

### ShowCar.java
```java
package homeworks.homework09;

import java.util.Objects;

public class ShowCar extends Car {
    private int stars;

    public ShowCar() {
        super();
        this.stars = 0;
    }

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration,
            int suspension, int durability, int stars) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = stars;
    }

    public int getStars() { return stars; }
    public void setStars(int stars) { this.stars = stars; }

    @Override
    public String toString() {
        return super.toString() + ", Звёзды: " + stars;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}
```

### Race.java
```java
package homeworks.homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race() {
        this.participants = new ArrayList<>();
    }

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    public int getPrizePool() { return prizePool; }
    public void setPrizePool(int prizePool) { this.prizePool = prizePool; }
    public List<Car> getParticipants() { return participants; }
    public void setParticipants(List<Car> participants) { this.participants = participants; }
    public void addParticipant(Car car) { this.participants.add(car); }

    @Override
    public String toString() {
        return String.format("Гонка: %s, Длина: %d, Призовой фонд: %d, Участников: %d", route, length, prizePool, participants.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length && prizePool == race.prizePool && Objects.equals(route, race.route) && Objects.equals(participants, race.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prizePool, participants);
    }
}
```

### CasualRace.java
```java
package homeworks.homework09;

public class CasualRace extends Race {
    public CasualRace() { super(); }
    public CasualRace(int length, String route, int prizePool) { super(length, route, prizePool); }
    @Override
    public String toString() {
        return "Обычная " + super.toString();
    }
}
```

### DragRace.java
```java
package homeworks.homework09;

public class DragRace extends Race {
    public DragRace() { super(); }
    public DragRace(int length, String route, int prizePool) { super(length, route, prizePool); }
    @Override
    public String toString() {
        return "Драг " + super.toString();
    }
}
```

### DriftRace.java
```java
package homeworks.homework09;

public class DriftRace extends Race {
    public DriftRace() { super(); }
    public DriftRace(int length, String route, int prizePool) { super(length, route, prizePool); }
    @Override
    public String toString() {
        return "Дрифт " + super.toString();
    }
}
```

### Garage.java
```java
package homeworks.homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public Garage(List<Car> parkedCars) {
        this.parkedCars = parkedCars != null ? parkedCars : new ArrayList<>();
    }

    public List<Car> getParkedCars() { return parkedCars; }
    public void setParkedCars(List<Car> parkedCars) { this.parkedCars = parkedCars; }
    public void parkCar(Car car) { this.parkedCars.add(car); }
    public void modifyCar(int index, Car newCar) {
        if (index >= 0 && index < parkedCars.size()) {
            parkedCars.set(index, newCar);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Гараж содержит: ").append(parkedCars.size()).append(" автомобилей\n");
        for (int i = 0; i < parkedCars.size(); i++) {
            sb.append(i + 1).append(") ").append(parkedCars.get(i)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkedCars);
    }
}
```