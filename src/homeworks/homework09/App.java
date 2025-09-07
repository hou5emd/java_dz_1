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
