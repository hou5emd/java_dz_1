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

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void parkCar(Car car) {
        this.parkedCars.add(car);
    }

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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkedCars);
    }
}
