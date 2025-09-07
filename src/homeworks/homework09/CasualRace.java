package homeworks.homework09;

public class CasualRace extends Race {
    public CasualRace() {
        super();
    }

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        return "Обычная " + super.toString();
    }
}
