package homeworks.homework09;

import java.nio.file.*;
import java.util.List;

public class App {

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
                    car = new ShowCar(brand, model, year, horsepower, acceleration, suspension,
                            durability, stars);
                } else {
                    car = new Car(brand, model, year, horsepower, acceleration, suspension,
                            durability);
                }
                garage.parkCar(car);

                Race race;
                switch (raceType) {
                    case "TimeLimitRace":
                        race = new TimeLimitRace(length, route, prizePool, raceParam);
                        break;
                    case "CircuitRace":
                        race = new CircuitRace(length, route, prizePool, raceParam);
                        break;
                    case "CasualRace":
                        race = new CasualRace(length, route, prizePool);
                        break;
                    case "DragRace":
                        race = new DragRace(length, route, prizePool);
                        break;
                    case "DriftRace":
                        race = new DriftRace(length, route, prizePool);
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

        runFileTask();
    }
}
