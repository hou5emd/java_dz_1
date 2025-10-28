package ru.inno.java.model.race;


import java.util.ArrayList;
import java.util.List;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.inno.java.model.car.Car;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Race {
    private int length;
    private String route;
    private int prizePool;
    @Builder.Default
    private List<Car> participants = new ArrayList<>();

    public void addParticipant(Car car) {
        this.participants.add(car);
    }
}
