public enum GameResult {
    STONE(0),
    SCISSORS(1),
    PAPER(2);

    private final Number value;

    GameResult(Number value) {
        this.value = value;
    }

    public static GameResult getByValue(Number value) {
        for (GameResult result : GameResult.values()) {
            if (result.value.equals(value)) {
                return result;
            }
        }
        throw new IllegalArgumentException("value does not exist in GameResult");
    }
}
