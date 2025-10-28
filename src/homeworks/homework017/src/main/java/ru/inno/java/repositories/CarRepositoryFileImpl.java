package ru.inno.java.repositories;

import ru.inno.java.model.car.Car;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {
    private static final String FILE_NAME = "resources/car-resource.csv";
    private static final Path filePath = Paths.get(FILE_NAME);


    @Override
    public int getLastId() {
        return 0;
    }

    @Override
    public void add(int id, Car car) {

    }

    @Override
    public List<Car> getAll() {
        return List.of();
    }
}
