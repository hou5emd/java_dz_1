
import java.security.SecureRandom;
import java.util.Arrays;

// Можно доработать до Player[]

public class SuEFaGame {
    Player playerOne;
    Player playerTwo;

    public SuEFaGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public GameResult getPlayerResult() {
        SecureRandom rn = new SecureRandom();

        return GameResult.getByValue(rn.nextInt(3));
    }

    public void play() {
        GameResult[][] winnerCombinations = {{GameResult.STONE, GameResult.SCISSORS},
                {GameResult.PAPER, GameResult.STONE}, {GameResult.SCISSORS, GameResult.PAPER}};
        GameResult playerOneResult = this.getPlayerResult();
        GameResult playerTwoResult = this.getPlayerResult();

        // Наверное можно более оптимально
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Результаты:");
        System.out.println(playerOne.name + ": " + playerOneResult + ";");
        System.out.println(playerTwo.name + ": " + playerTwoResult + ";");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        if (playerOneResult.equals(playerTwoResult)) {
            System.out.println("Ничья");
            return;
        }
        for (GameResult[] winnerCombination : winnerCombinations) {

            if (Arrays.equals(winnerCombination,
                    new GameResult[] {playerOneResult, playerTwoResult})) {
                System.out.println("Выиграл: " + playerOne.name);
                break;
            }

            if (Arrays.equals(winnerCombination,
                    new GameResult[] {playerTwoResult, playerOneResult})) {
                System.out.println("Выиграл: " + playerTwo.name);
                break;
            }

        }
    }



}
