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

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

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
