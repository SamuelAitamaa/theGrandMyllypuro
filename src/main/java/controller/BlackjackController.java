package controller;

import model.*;
import view.InGameViewController;
import view.SettingsViewController;

import java.util.ArrayList;

/**
 * Used to control GUI from model and model from GUI
 */
public class BlackjackController {

    private BlackjackGame blackJackGame;
    private Player player;
    private Hand handObjectPlayer;
    private ArrayList<Card> handPlayer;
    private ArrayList<Card> splittedHandPlayer;
    private Dealer dealer;
    private Hand handObjectDealer;
    private ArrayList<Card> handDealer;
    private InGameViewController inGameViewController;
    private String winner;
    private boolean doublePossibility;
    private boolean splitPossibility;
    private boolean splitIsOn = false;


    /**
     * Constructor of BlackjackController
     */
    public BlackjackController() {
        this.blackJackGame = new BlackjackGame(this);
        this.player = blackJackGame.getPlayer();
        this.handObjectPlayer = player.getHand();
        this.handPlayer = handObjectPlayer.getHand();
        this.splittedHandPlayer = handObjectPlayer.getSplittedHand();
        this.dealer = blackJackGame.getDealer();
        this.handObjectDealer = dealer.getHand();
        this.handDealer = handObjectDealer.getHand();
    }


    /**
     * Starts next round in blackjack game
     */
    public void nextRound() {
        this.blackJackGame.initRound();

    }

    /**
     * Player hits and gets a new card
     */
    public void hit() {
        this.blackJackGame.playerHit();
    }

    /**
     * Player stands and then it is Dealer's turn to play
     */

    public void stand() {
        this.blackJackGame.playerStay();
    }

    /**
     * Player sets the bet to the beginning round
     * @param b - amount of the bet
     * @return - true if the bet is set, false if the player doesn't have enough online cash for setting the bet
     */

    public boolean setBet(int b) {
        return this.player.setBet(b);
    }

    public boolean setSplitBet(int b) {
        return this.player.setSplitBet(b);
    }

    /**
     * Gets the hand of the Player
     * @return
     */
    public ArrayList<Card> getPlayersCards() {
        return this.handPlayer;
    }

    public ArrayList<Card> getPlayersSplittedCards() { return this.splittedHandPlayer;}

    /**
     * Gets the hand of the Dealer
     * @return
     */
    public ArrayList<Card> getDealersCards() {
        return this.handDealer;
    }

    /**
     * Sets the player's cards to UI
     * @param playersCards - Cards that the player currently has
     */

    public void setPlayersCardsToUI(ArrayList<Card> playersCards) {
        inGameViewController.setPlayersCards(playersCards);
    }

    public void setPlayersSplittedCardsToUI(ArrayList<Card> playersSplittedCards) {
        inGameViewController.setPlayersSplittedCards(playersSplittedCards);
    }

    public void setSplitStatus(boolean splitIsOn) {
        this.splitIsOn = splitIsOn;
    }

    public boolean getSplitStatus() {
        return this.splitIsOn;
    }

    public void hitToSplittedHand() {
        this.blackJackGame.hitToSplittedHand();
    }

    /**
     * Sets the dealer's cards to UI
     * @param dealersCards - Cards that the dealer currently has
     */
    public void setDealersCardsToUI(ArrayList<Card> dealersCards) {
        inGameViewController.setDealersCards(dealersCards);
    }

    /**
     * Returns the player
     * @return - The player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the dealer
     * @return - the dealer
     */

    public Dealer getDealer() {
        return this.dealer;
    }

    /**
     * Sets the InGameViewController to allow communication
     * @param inGameViewController - Game window controller
     */
    public void setInGameViewController(InGameViewController inGameViewController) {
        this.inGameViewController = inGameViewController;
    }

    /**
     * Declares the winner of the round
     * @param winner - Winner of the round
     * @throws InterruptedException
     */
    public void declareWinner(String winner) throws InterruptedException {
        inGameViewController.declareWinner(winner);
    }

    /**
     * Disables hit button if the player hits a blackjack (21)
     */
    public void disableHit() {
        inGameViewController.disableHit();
    }

    /**
     * For testing purposes only
     * @return BlackJackGame-object created in the constructor
     */
    public BlackjackGame getBlackJackGame() {
        return blackJackGame;
    }

    public boolean getDoublePossibility() {
        return this.doublePossibility;
    }

    public void setDoublePossibility(boolean doublePossibility) {
        this.doublePossibility = doublePossibility;
    }

    public void playerDouble() {
        this.blackJackGame.playerDouble();
    }

    public void disableStand() {
        inGameViewController.disableStand();
    }

    public void setSplitPossibility(boolean splitPossibility) {
        this.splitPossibility = splitPossibility;
    }

    public boolean getSplitPossibility() {
        return this.splitPossibility;
    }

    public void playerSplit() {
        this.blackJackGame.playerSplit();
    }

    public void showHitTip() {
        inGameViewController.showHitTip();
    }

    public void showStandTip() {
        inGameViewController.showStandTip();
    }

    public void showDoubleTip() {
        inGameViewController.showDoubleTip();
    }

    public void showSplitTip() {
        inGameViewController.showSplitTip();
    }
}
