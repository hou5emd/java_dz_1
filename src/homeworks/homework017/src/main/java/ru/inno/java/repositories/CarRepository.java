package ru.inno.java.repositories;

import ru.inno.java.model.car.Car;

import java.util.List;

public interface CarRepository {

    int getLastId();

    void add(int id, Car car);

    List<Car> getAll();


}
