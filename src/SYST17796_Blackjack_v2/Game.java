package SYST17796_Blackjack_v2;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier William Ibarra August 2021
 */
public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game (String name) {
        this.name = name;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName () {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers () {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers (ArrayList<Player> players) {
        this.players = players;
    }

    public abstract void play (BlackJackDealer dealer, BlackJackPlayer player, Deck deck);

    public abstract void declareWinner (Player person);
}//end class
