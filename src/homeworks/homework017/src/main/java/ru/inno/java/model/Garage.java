package ru.inno.java.model;

import lombok.*;
import ru.inno.java.model.car.Car;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        this.parkedCars.add(car);
    }

    public void modifyCar(int index, Car newCar) {
        if (index >= 0 && index < parkedCars.size()) {
            parkedCars.set(index, newCar);
        }
    }
}
