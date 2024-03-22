package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Round {
    private String winner;

    public Round(String player1, Card card1, String player2, Card card2, Card vira){
        int res = card1.compareValueTo(card2, vira);

        if (res == 0) winner = null;
        else if (res > 0) winner = player1;
        else winner = player2;
    }

    public String getWinner(){
        return this.winner;
    }
}
