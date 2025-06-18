public class App {
    public static void main(String[] args) throws Exception {
        Player playerOne = new Player("Вася");
        Player playerTwo = new Player("Петя");
        SuEFaGame game = new SuEFaGame(playerOne, playerTwo);
        game.play();
    }
}
