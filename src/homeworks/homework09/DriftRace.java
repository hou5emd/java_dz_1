package homeworks.homework09;

public class DriftRace extends Race {
    public DriftRace() {
        super();
    }

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        return "Дрифт " + super.toString();
    }
}
