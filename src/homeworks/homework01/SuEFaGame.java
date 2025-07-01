package homeworks.homework01;

import java.security.SecureRandom;
import java.util.Arrays;

// Можно доработать до Player[]

public class SuEFaGame {
    User playerOne;
    User playerTwo;

    public SuEFaGame(User playerOne, User playerTwo) {
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
        User winner = null;
        for (GameResult[] winnerCombination : winnerCombinations) {

            if (Arrays.equals(winnerCombination,
                    new GameResult[] {playerOneResult, playerTwoResult})) {
                winner = playerOne;
                break;
            }
        }
        if (winner == null) {
            winner = playerTwo;
        }
        System.out.println("Выиграл: " + winner.name);

    }



}
