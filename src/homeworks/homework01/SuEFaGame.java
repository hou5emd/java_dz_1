package homeworks.homework01;

import java.security.SecureRandom;
import java.util.Arrays;

// Можно доработать до Player[]
public class SuEFaGame {
    User userOne;
    User userTwo;

    public SuEFaGame(User playerOne, User playerTwo) {
        this.userOne = playerOne;
        this.userTwo = playerTwo;
    }

    public PossibleValue getPlayerResult() {
        SecureRandom rn = new SecureRandom();
        return PossibleValue.getByValue(rn.nextInt(3));
    }

    public void play() {
        PossibleValue[][] winnerCombinations = {{PossibleValue.STONE, PossibleValue.SCISSORS},
                {PossibleValue.PAPER, PossibleValue.STONE}, {PossibleValue.SCISSORS, PossibleValue.PAPER}};
        PossibleValue playerOneResult = this.getPlayerResult();
        PossibleValue playerTwoResult = this.getPlayerResult();

        // Наверное можно более оптимально
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Результаты:");
        System.out.println(userOne.name + ": " + playerOneResult + ";");
        System.out.println(userTwo.name + ": " + playerTwoResult + ";");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        if (playerOneResult.equals(playerTwoResult)) {
            System.out.println("Ничья");
            return;
        }
        User winner = null;
        for (PossibleValue[] winnerCombination : winnerCombinations) {

            if (Arrays.equals(winnerCombination,
                    new PossibleValue[] {playerOneResult, playerTwoResult})) {
                winner = userOne;
                break;
            }
        }
        if (winner == null) {
            winner = userTwo;
        }
        System.out.println("Выиграл: " + winner.name);

    }



}
