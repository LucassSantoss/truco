package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

public class Hand {
    private Player player1;
    private Player player2;
    private Card vira;
    private Round[] rounds;
    private int numOfRounds;

    public Hand(Player player1, Player player2){
        Deck deck = new Deck();
        deck.shuffle();
        this.vira = deck.takeOne();

        this.player1 = player1;
        player1.setCards(deck.take(3));

        this.player2 = player2;
        player2.setCards(deck.take(3));

        this.rounds = new Round[3];
    }

    public void playRound(){
        if (numOfRounds < 3){
            Round round = new Round(player1.getName(), player1.chooseCard(), player2.getName(), player2.chooseCard(), vira);
            rounds[numOfRounds++] = round;
            System.out.printf("Vencedor da rodada %d: %s\n", numOfRounds, round.getWinner());
        }
    }

    public boolean isDone(){
        if (numOfRounds < 2) return false;
        if (numOfRounds == 3) return true;
        final String winner1 = rounds[0].getWinner();
        final String winner2 = rounds[1].getWinner();

        if (winner1 == null && winner2 == null) return false;
        if (winner1 != null && winner2 == null) return true;
        if (winner1 == null && winner2 != null) return true;
        return winner1.equals(winner2);
    }

    public String getWinner(){
        if (!this.isDone()) return null;
        player1.resetNumOfCards();
        player2.resetNumOfCards();
        String winner1 = rounds[0].getWinner();
        String winner2 = rounds[1].getWinner();
        if (winner1 == null && winner2 != null) return winner2;
        if (winner1 != null && winner2 == null) return winner1;
        if (winner1.equals(winner2)) return winner1;
        String winner3 = rounds[2].getWinner();
        if (winner1 != null && winner2 != null && winner3 == null) return winner1;
        if (winner1.equals(winner3)) return winner1;
        return winner2; //winner2.equals(winner3)
    }

}
