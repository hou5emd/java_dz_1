package homeworks.homework09;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace() {
        super();
        this.goldTime = 0;
    }

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    public int getGoldTime() { return goldTime; }
    public void setGoldTime(int goldTime) { this.goldTime = goldTime; }

    @Override
    public String toString() {
        return "Гонка на время " + super.toString() + ", Золотое время: " + goldTime;
    }
}
