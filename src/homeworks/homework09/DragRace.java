package homeworks.homework09;

public class DragRace extends Race {
    public DragRace() {
        super();
    }

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        return "Драг " + super.toString();
    }
}
