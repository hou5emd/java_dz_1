package homeworks.homework01;
public class Task2 {
    public static void main(String[] args) throws Exception {
        Player playerOne = new Player("Вася");
        Player playerTwo = new Player("Петя");
        SuEFaGame game = new SuEFaGame(playerOne, playerTwo);
        game.play();
    }
}
