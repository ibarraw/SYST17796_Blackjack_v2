package SYST17796_Blackjack_v2;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Xianjun Wang July 2021
 * @modifier William Ibarra August 2021
 */
public abstract class Player {

    private String name; //the unique name for this player
    private GroupOfCards hand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     * @param hand
     */
    public Player (String name, GroupOfCards hand) {
        this.name = name;
        this.hand = hand;
    }

    /**
     * @return the player name
     */
    public String getName () {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName (String name) {
        this.name = name;
    }

    public GroupOfCards getHand () {
        return hand;
    }

    public void setHand (GroupOfCards hand) {
        this.hand = hand;
    }
}
