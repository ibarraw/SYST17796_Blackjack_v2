package SYST17796_Blackjack_v2;
import java.util.Scanner;
/**
 * This class is used to hold the BlackJack Card Game
 *
 * @author Xianjun Wang July 2021
 * @modifier William Ibarra July 2021
 */
public class BlackJackGame extends Game {

    public BlackJackGame (String name) {
        super(name);
    }

    //Method for playing BlackJack Card game
    @Override
    public void play (GroupOfCards dealer, GroupOfCards player, Deck deck) {
        Deck cardDeck = new Deck();
        Scanner input = new Scanner(System.in);
        if (cardDeck.checkHandValue(dealer) == 21) {
            declareWinner(dealer);
        }
        else if (cardDeck.checkHandValue(player) == 21) {
            declareWinner(player);
        }
        while (cardDeck.checkHandValue(player) < 21) {
            System.out.println("\nWould you like to 'hit' or 'stay'?");
            String choice = (input.nextLine());
            if (choice.equalsIgnoreCase("hit")) {
                cardDeck.deal(1, player);
                System.out.println("New hand value: " + cardDeck.checkHandValue(player));
                System.out.println("Dealer hand value: " + cardDeck.checkHandValue(dealer));
                if (cardDeck.checkHandValue(player) > 21) {
                    declareWinner(dealer);
                    break;
                }
                else if (cardDeck.checkHandValue(player) > cardDeck.checkHandValue(dealer)) {
                    declareWinner(player);
                    break;
                }
            }
            else if (choice.equalsIgnoreCase("stay")) {
                if (cardDeck.checkHandValue(player) > 21) {
                    declareWinner(dealer);
                    break;
                }
                else if (cardDeck.checkHandValue(player) > cardDeck.checkHandValue(dealer)) {
                    declareWinner(player);
                    break;
                }
            }
        }
    }

    @Override
    public void declareWinner (GroupOfCards person) {
        System.out.println("\nThe " + person.getName() + " has won the game!");
    }
}
