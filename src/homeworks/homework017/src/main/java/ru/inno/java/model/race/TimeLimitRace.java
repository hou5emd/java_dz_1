package ru.inno.java.model.race;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
public class TimeLimitRace extends Race {
    private int goldTime = 0;
}
