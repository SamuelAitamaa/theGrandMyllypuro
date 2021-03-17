package model;

import java.util.ArrayList;

/**
 * Represents a player of the game
 */
public class Player {

    /**
     * Hand of a player
     */
    private Hand hand;

    /**
     * Counter for how many round the player has won
     */
    private int amountOfWins = 0;
    /**
     * An integer which describes the total amount of onlinecash the player has
     */
    private int currency;
    /**
     * An integer which describes the bet the player has in one BlackJack-round
     */
    private int bet;

    private int splitBet;

    /**
     * Initializes new Player-object
     */
    public Player(int currency) {
        this.hand = new Hand();
        this.currency = currency;
    }

    /**
     * Gets the hand of the player
     * @return
     */
    public Hand getHand() {
        return this.hand;
    }

    /**
     * Adds one win to players amountOfWins-attribute and increases the amount of online cash the player has
     */
    public void win(String method) {
        amountOfWins++;
        if (method.equals("Blackjack")) {
            this.currency += (bet * 3);
        } else {
            this.currency += (bet * 2);
        }
        if (UserCredentialHandler.getInstance().isLoggedIn()) {
            UserCredentialHandler.getInstance().getLoggedInUser().setBalance(this.currency);
        }
    }

    public void setNewBalance() {
        this.currency = 2500;
        if (UserCredentialHandler.getInstance().isLoggedIn()) {
            UserCredentialHandler.getInstance().getLoggedInUser().setBalance(this.currency);
        }
    }

    /**
     * Decreases the amount of online cash the player has
     */
    public void lose() {
        if (UserCredentialHandler.getInstance().isLoggedIn()) {
            UserCredentialHandler.getInstance().getLoggedInUser().setBalance(this.currency);
        }
    }

    /**
     * Gets the amountOfWins
     * @return - The amountOfWins
     */
    public int getWins() {
        return amountOfWins;
    }

    /**
     * Gets the player's current balance
     * @return - The balance
     */
    public int getCurrency() {
        return this.currency;
    }

    /**
     * Sets the bet-attribute to a player if the player has enough online cash
     *
     * @param b integer which describes the value of a bet
     * @return true if the bet is set, false if the player doesn't have enough online cash for setting the bet
     */
    public boolean setBet(int b) {
        if (this.currency < b) {
            Logger.log(Logger.LogLevel.PROD, "Saldo ("+currency+") ei riitä panoksen ("+b+") asettamiseen.");
            return false;
        } else {
            this.bet = b;
            this.currency -= bet;
            return true;
        }
    }

    /**
     * Sets the bet-attribute to a player's splitted hand
     * @param b - the amount of bet
     * @return - true if the bet is set, false if the player doesn't have enough online cash for setting the bet
     */
    public boolean setSplitBet(int b) {
        if (this.currency < b) {
            Logger.log(Logger.LogLevel.PROD, "Saldo ("+currency+") ei riitä panoksen ("+b+") asettamiseen.");
            return false;
        } else {
            this.splitBet = b;
            this.currency -= splitBet;
            return true;
        }
    }

    /**
     * Doubles the player's current bet
     */
    public void doubleBet() {
        this.currency -= bet;
        this.bet = bet * 2;
    }

    /**
     * Gets the amount of bet
     * @return - the amount of bet
     */
    public int getBet() {
        return bet;
    }
}
