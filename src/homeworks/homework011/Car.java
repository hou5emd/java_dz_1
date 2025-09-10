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
