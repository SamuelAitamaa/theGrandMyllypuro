
package model;

import java.io.Serializable;

public class Dealer implements Serializable {

    private Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }

    // Determines if dealer has a blackjack
    public boolean isBlackjack() {
        if (hand.calculateTotal() == 21) {
            return true;
        } else {
            return false;
        }
    }

    // This automates the dealer's play
    /*public void dealerPlay(Deck deck) {
        System.out.println("Dealer plays\n");
        while (hand.calculateTotal() <= 16) {
            System.out.println("Dealer has " + hand.calculateTotal() + " and hits");
            hand.addCard(deck.nextCard());
            //System.out.println("Dealer " + this.getHandString(true, false));
        }
        if (hand.calculateTotal() > 21) {
            System.out.println("Dealer busts. ");// + this.getHandString(true, false));
        } else {
            System.out.println("Dealer stands at " + hand.calculateTotal());// + this.getHandString(true, false));
        }
    }*/

    /**
     * Prints Dealers hand
     */
    public void printHand() {
        Logger.log(Logger.LogLevel.DEV, "Dealers hand:");
        hand.printHand();
    }

    // Adds a card o the dealer's hand
    public void addCard(Card card) {
        hand.addCard(card);
    }
    /*
    // Gets the dealer's hand as a string
    public String getHandString(boolean isDealer, boolean hideHoleCard) {
        String str = "Cards:" + hand.toString(isDealer, hideHoleCard);

        return str;
    }
    */

    // Calculates the dealer's hand total
    public int calculateTotal() {
        return hand.calculateTotal();
    }

    // Clears the dealer's hand
    public void clearHand() {
        hand.clearHand();
    }

    // Peeks the dealer's face-down card
    public boolean peek() {
        return hand.dealerPeek();
    }

    public Hand getHand() {
        return this.hand;
    }


} //End class
