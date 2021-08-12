package SYST17796_Blackjack_v2;
import java.util.Scanner;
/**
 * This class is used to hold the BlackJack Card Game
 *
 * @author Xianjun Wang July 2021
 * @modifier William Ibarra August 2021
 */
public class BlackJackGame extends Game {

    public BlackJackGame (String name) {
        super(name);
    }

    /**
     *
     * @param dealer
     * @param player
     * @param deck
     */
    @Override //Method for playing BlackJack Card game
    public void play (BlackJackDealer dealer, BlackJackPlayer player, Deck deck) {

        //NOTES: Deck checkHandValue() was renamed to CHValue() to save space

        Scanner input = new Scanner(System.in);
        if (deck.CHValue(dealer.getHand()) == 21) { //If dealer hand == 21; declareWinner: dealer
            declareWinner(dealer);
        }
        else if (deck.CHValue(player.getHand()) == 21) { //If player hand == 21; declareWinner: player
            declareWinner(player);
        }
        while (deck.CHValue(player.getHand()) < 21) { //While player hand < 21
            System.out.println("\nWould you like to 'hit' or 'stay'?");
            String choice = (input.nextLine()); //console input here

            //---------------------------------------------------------------------------
            if (choice.equalsIgnoreCase("hit")) { //if choice not case sensitive: 'hit'
                deck.deal(1, player.getHand()); //deal 1 card to player
                System.out.println("New hand value: " + deck.CHValue(player.getHand()));
                System.out.println("Dealer hand value: " + deck.CHValue(dealer.getHand()));

                if (deck.CHValue(player.getHand()) > 21) { //If player hand > 21; declareWinner: dealer
                    declareWinner(dealer);
                    break; //stop while loop
                }
                else if (deck.CHValue(player.getHand()) > deck.CHValue(dealer.getHand())) { //If player hand > dealer hand; declareWinner: player
                    declareWinner(player);
                    break; //stop while loop
                }
            } //hit ends
            //---------------------------------------------------------------------------
            else if (choice.equalsIgnoreCase("stay")) { //If choice not case sensitive: 'stay'
                if (deck.CHValue(player.getHand()) < 21) { //if player hand < 21; declareWinner: dealer
                    declareWinner(dealer);
                    break; //stop while loop
                }
                else if (deck.CHValue(player.getHand()) > deck.CHValue(dealer.getHand())) { //If player hand > dealer hand; declareWinner: player
                    declareWinner(player);
                    break; //stop while loop
                }
            } //stay ends
        } //while loop ends here
    } //play() ends here

    @Override
    public void declareWinner (Player person) {
        System.out.println("\nThe " + person.getName() + " has won the game!");
    }
}
