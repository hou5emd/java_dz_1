package homeworks.homework01;
public enum PossibleValue {
    STONE(0), SCISSORS(1), PAPER(2);

    private final Number value;

    PossibleValue(Number value) {
        this.value = value;
    }

    public static PossibleValue getByValue(Number value) {
        for (PossibleValue result : PossibleValue.values()) {
            if (result.value.equals(value)) {
                return result;
            }
        }
        throw new IllegalArgumentException("value does not exist in GameResult");
    }
}
