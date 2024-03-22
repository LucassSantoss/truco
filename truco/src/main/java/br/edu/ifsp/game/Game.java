package br.edu.ifsp.game;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Hand[] hands;
    private int numOfHands = 0;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        hands = new Hand[30];

        hands[numOfHands] = new Hand(player1, player2);
    }

    public void play(){
        if (!hands[numOfHands].isDone()){
            hands[numOfHands].playRound();
        }

        if(hands[numOfHands].isDone()){
            if (hands[numOfHands].getWinner().equals(player1.getName())) player1.incrementScore();
            if (hands[numOfHands].getWinner().equals(player2.getName())) player2.incrementScore();
            if (hands[numOfHands].getWinner() != null){
                System.out.printf("Vencedor da mão %d: %s\n", numOfHands+1, hands[numOfHands].getWinner());
            }
            else{
                System.out.printf("Vencedor da mão %d: empate\n", numOfHands);
            }
            numOfHands++;
            hands[numOfHands] = new Hand(player1, player2);
        }
    }

    public boolean isDone(){
        return player1.getScore() == 12 || player2.getScore() == 12;
    }

    public Player getWinner(){
        if (this.isDone()){
            if (player1.getScore() == 12) return player1;
            return player2;
        }
        return null;
    }
}
