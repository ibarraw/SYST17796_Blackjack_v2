package SYST17796_Blackjack_v2;

/**
 * Main for BlackJack game
 *
 * @author Xianjun Wang July 2021
 * @modifier Chun Kiu So August 2021
 * @modifier William Ibarra August 2021
 * @modifier Xianjun Wang August 2021
 *
 */
public class PlayBlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {

        //create a BlackJackGame object
        BlackJackGame blackjack = new BlackJackGame("Blackjack");

        //call run() method to play the BlackJackGame
        blackjack.run();
    }
}
