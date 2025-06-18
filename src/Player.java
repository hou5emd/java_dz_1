import java.security.SecureRandom;

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public GameResult playSuEFa() {
        SecureRandom rn = new SecureRandom();

        return GameResult.getByValue(rn.nextInt(3));
    }

}
