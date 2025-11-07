package ru.inno.java;

import ru.inno.java.model.Garage;
import ru.inno.java.model.car.Car;
import ru.inno.java.model.car.PerformanceCar;
import ru.inno.java.model.car.ShowCar;
import ru.inno.java.model.race.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void runFileTask() {
        Path inputPath = Paths.get("src/homeworks/homework09/input.txt");
        Path outputPath = Paths.get("src/homeworks/homework09/output.txt");
        StringBuilder result = new StringBuilder();
        Garage garage = new Garage();

        try {
            List<String> lines = Files.readAllLines(inputPath);
            for (String line : lines) {
                if (line.trim().isEmpty() || line.startsWith("#"))
                    continue;
                String[] parts = line.split(";");
                String raceType = parts[0];
                int length = Integer.parseInt(parts[1]);
                String route = parts[2];
                int prizePool = Integer.parseInt(parts[3]);
                int raceParam = Integer.parseInt(parts[4]);
                String brand = parts[5];
                String model = parts[6];
                int year = Integer.parseInt(parts[7]);
                int horsepower = Integer.parseInt(parts[8]);
                int acceleration = Integer.parseInt(parts[9]);
                int suspension = Integer.parseInt(parts[10]);
                int durability = Integer.parseInt(parts[11]);
                String carType = parts[12];
                String carParam = parts.length > 13 ? parts[13] : "";

                Car car;
                if (carType.equalsIgnoreCase("Performance")) {
                    String[] addOns = carParam.split(",");
                    car = new PerformanceCar(brand, model, year, horsepower, acceleration,
                            suspension, durability, addOns);
                } else if (carType.equalsIgnoreCase("Show")) {
                    int stars = 0;
                    try {
                        stars = Integer.parseInt(carParam);
                    } catch (Exception e) {
                    }
                    car = ShowCar.builder()
                            .brand(brand)
                            .model(model)
                            .year(year)
                            .horsepower(horsepower)
                            .acceleration(acceleration)
                            .suspension(suspension)
                            .durability(durability)
                            .stars(stars)
                            .build();
                } else {
                    car = new Car(brand, model, year, horsepower, acceleration, suspension,
                            durability);
                }
                garage.parkCar(car);

                Race race;
                switch (raceType) {
                    case "TimeLimitRace":
                        race = TimeLimitRace.builder()
                                .length(length)
                                .route(route)
                                .prizePool(prizePool)
                                .goldTime(raceParam)
                                .build();
                        break;
                    case "CircuitRace":
                        race = CircuitRace.builder()
                                .length(length)
                                .route(route)
                                .prizePool(prizePool)
                                .laps(raceParam)
                                .build();
                        break;
                    case "CasualRace":
                        race = CasualRace.builder()
                                .length(length)
                                .route(route)
                                .prizePool(prizePool)
                                .build();
                        break;
                    case "DragRace":
                        race = DragRace.builder()
                                .length(length)
                                .route(route)
                                .prizePool(prizePool)
                                .build();
                        break;
                    case "DriftRace":
                        race = DriftRace.builder()
                                .length(length)
                                .route(route)
                                .prizePool(prizePool)
                                .build();
                        break;
                    default:
                        race = null;
                }
                if (race != null) {
                    race.addParticipant(car);
                    result.append(race.toString()).append("\n");
                    result.append("Участник: ").append(car.toString()).append("\n\n");
                }
            }
            result.append(garage.toString());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Files.write(outputPath, result.toString().getBytes());
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020, 120, 10, 15, 100);
        PerformanceCar perfCar = new PerformanceCar("Ferrari", "488", 2022, 670, 8, 20, 90,
                new String[]{"Turbo", "Nitro"});
        ShowCar showCar = ShowCar.builder()
                .brand("Lamborghini")
                .model("Aventador")
                .year(2021)
                .horsepower(750)
                .acceleration(7)
                .suspension(18)
                .durability(80)
                .stars(5)
                .build();

        System.out.println(car1);
        System.out.println(perfCar);
        System.out.println(showCar);

        Race casual = CasualRace.builder()
                .length(5000)
                .route("City")
                .prizePool(10000)
                .build();
        Race drag = DragRace.builder()
                .length(1000)
                .route("Highway")
                .prizePool(15000)
                .build();
        Race drift = DriftRace.builder()
                .length(3000)
                .route("Mountain")
                .prizePool(12000)
                .build();

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

        runFileTask();
    }
}