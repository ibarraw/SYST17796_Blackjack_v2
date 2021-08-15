package SYST17796_Blackjack_v2;

/**
 * This class is used to hold Black Jack Card game players.
 *
 * @author Xianjun Wang July 2021
 * @modifier William Ibarra July 2021
 */
public class BlackJackPlayer extends Player {

    //Player constructor for the players and the dealer
    //Takes in a name, and the generated group of cards
    public BlackJackPlayer (String name, GroupOfCards hand) {
        super(name, hand);
    }
}
