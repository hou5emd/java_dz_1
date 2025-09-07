package homeworks.homework09;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace() {
        super();
        this.laps = 0;
    }

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    public int getLaps() { return laps; }
    public void setLaps(int laps) { this.laps = laps; }

    @Override
    public String toString() {
        return "Кольцевая гонка " + super.toString() + ", Кругов: " + laps;
    }
}
