package ru.inno.java.model.car;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
}
