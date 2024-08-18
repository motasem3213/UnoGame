import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Game game = new UnoGame();


        game.addPlayer(new Player("Motasem"));
        game.addPlayer(new Player("Fahed"));
        game.addPlayer(new Player("Ahmad"));

        game.play();

    }

}