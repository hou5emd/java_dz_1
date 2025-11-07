package ru.inno.java.model.race;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder
public class CircuitRace extends Race {
    @Builder.Default
    private int laps = 0;
}
