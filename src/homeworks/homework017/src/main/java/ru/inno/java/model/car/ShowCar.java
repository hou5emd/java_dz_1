package ru.inno.java.model.car;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ShowCar extends Car {
    @Builder.Default
    private int stars = 0;
}
