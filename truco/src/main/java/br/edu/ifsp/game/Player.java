package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Player {
    private final String name;
    private int score;
    private Card[] cards;
    public int numOfCard = 0;

    public Player(String name){
        this.name = name;
    }

    public void setCards(Card[] cards){
        this.cards = cards;
    }

    public Card chooseCard(){
        return this.cards[numOfCard++];
    }

    public void incrementScore(){
        this.score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void resetNumOfCards(){
        this.numOfCard = 0;
    }
}
