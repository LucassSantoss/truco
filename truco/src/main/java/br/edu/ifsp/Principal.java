package br.edu.ifsp;

import br.edu.ifsp.game.Game;
import br.edu.ifsp.game.Player;

public class Principal {
    public static void main(String[] args) {
        Player player1 = new Player("Lucas");
        Player player2 = new Player("Clara");
        Game game = new Game(player1, player2);
        while (!game.isDone()){
            game.play();
        }
        System.out.println("Vencedor do jogo: " + game.getWinner().getName());
        System.out.printf("Score player1: %d, Score player2: %d", player1.getScore(), player2.getScore());
    }
}
