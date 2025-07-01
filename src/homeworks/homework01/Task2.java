package homeworks.homework01;
public class Task2 {
    public static void main(String[] args) throws Exception {
        User playerOne = new User("Вася");
        User playerTwo = new User("Петя");
        SuEFaGame game = new SuEFaGame(playerOne, playerTwo);
        game.play();
    }
}
