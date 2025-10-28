package ru.inno.java.model.car;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Car {


        private String brand;
        private String model;
        private int year;
        private int horsepower;
        private int acceleration;
        private int suspension;
        private int durability;
}
