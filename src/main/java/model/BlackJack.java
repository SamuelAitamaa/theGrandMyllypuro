package model;

/**
 *
 *  Logic of Blackjack game
 *
 */

public class BlackJack {

    private int round;

    /**
     * Deck used in a blackjack game
     *
     */
    private Deck deck;

    /**
     * Player playing in a blackjack game
     *
     */
    private Player player;

    //private Dealer dealer;


    /**
     *
     * Initializes new Blackjack game
     *
     */
    public BlackJack() {

        this.round = 0;
        this.deck = new Deck();
        this.player = new Player();
        //this.dealer = new Dealer();

    }


    /**
     * Initializes new round in a blackjack game:
     * Shuffles deck and deals two cards for player and one for dealer.
     *
     */
    public void initRound() {
        this.round++;
        System.out.println("\n\n");
        System.out.println(String.format("Round %d begins!\n", round));
        deck.shuffleDeck();
        Card[] playerhand = {deck.getCardsInDeck()[0], deck.getCardsInDeck()[1]};
        //Card[] dealerhand = {deck.getCardsInDeck()[2]};
        this.player.setHand(playerhand);
        //this.dealer.setHand(dealerhand);
    }

    // NOTE: This is only for testing
    public void printDeckInGame() {
        this.deck.printDeck();

    }

}