package model;

import java.util.ArrayList;

/**
 * Represents a deck of cards
 */
public class Deck {

    /**
     * An array of cards which represents the deck.
     * Can contain maximum of 52 objects.
     */
    private ArrayList<Card> deck;

    /**
     * Initializes a new Deck-object and creates 52 Card-objects for the deck.
     */
    public Deck() {
        int rank = 1;
        int suit = 1;
        this.deck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            this.deck.add(new Card(rank, suit));
            rank++;
            if (rank > 13) {
                rank = 1;
                suit++;
            }
        }
    }

    /**
     * Returns cards in deck
     * @return array of cards
     */

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Returns the first Card-object and removes it from the ArrayList
     * @return the first card of the deck-array
     */
    public Card nextCard(){
        return this.deck.remove(0);
    }

    /**
     * Shuffles cards in deck
     *
     */
    public void shuffleDeck() {
        for (int i=0;i<deck.size();i++) {
            int rnd = (int) (Math.random() * deck.size());
            Card cardToMove = deck.get(i);
            deck.set(i, deck.get(rnd));
            deck.set(rnd, cardToMove);

        }
    }

    /**
     * Prints all Card-objects in the deck by calling the toString()-method from the Card-class
     */
    public void printCardsInDeck() {
        for (Card card: deck) {
            System.out.println(card.toString());
        }
    }

    /**
     * Clears the deck
     */
    public void clearDeck() {
        deck.clear();
    }

    /**
     * Used for JUnit tests
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        Deck d = (Deck) o;
        boolean equals = false;
        for (int i=0; i < deck.size(); i++) {
            if (deck.get(i).equals(d.getDeck().get(i))) {
                equals = true;
            } else {
                equals = false;
                break;
            }
        }
        return equals;
    }

    /**
     * Used only for debugging to set first three cards
     * @param card1
     * @param card2
     * @param card3
     */
    public void manipulateDeck(Card card1, Card card2, Card card3) {
        deck.add(0, card3);
        deck.add(0, card2);
        deck.add(0, card1);
    }

}

