package SYST17796_Blackjack_v2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to hold the BlackJack Card Game
 *
 * @author Xianjun Wang July 2021
 * @modifier William Ibarra August 2021
 * @modifier Kiu So August 2021
 * @modifier Xianjun Wang August 2021
 */
public class BlackJackGame extends Game {

    GroupOfCards dealerHand = new GroupOfCards();
    GroupOfCards playerHand = new GroupOfCards();
    BlackJackDealer dealer = new BlackJackDealer("Casino dealer", dealerHand);
    BlackJackPlayer player = new BlackJackPlayer("Casino player", playerHand);
    Deck deck = new Deck();

    //constructor
    public BlackJackGame(String name) {
        super(name);
    }

    // create run() method for being called in main method and playing BlackJackGame there
    public void run() {
        play(dealer, player, deck);
    }

    /**
     * @param dealer
     * @param player
     * @param deck
     */
    @Override //Method for playing BlackJack Card game
    public void play(BlackJackDealer dealer, BlackJackPlayer player, Deck deck) {

        //NOTES: Deck checkHandValue() was renamed to CHValue() to save space
        Scanner input = new Scanner(System.in);

        //generate the full deck of 52 cards for the game
        System.out.println("52 Cards in the deck when the game starts:");
        this.deck.printDeck();

        this.deck.deal(2, dealerHand);//deal 2 cards to dealer at the beginning of the game
        this.deck.deal(2, playerHand); //deal 2 cards to player at the beginning of the game

        //Cards left in the deck
        System.out.println("\nCards left in the deck after dealing:");
        this.deck.printDeck();

        //Cards in dealerHand and playerHand after dealing 2 cards at the beginning of the game
        System.out.println("\nCards in the player's hands:");
        playerHand.printDeck();
        System.out.println("\nCards in the dealer's hands:");
        dealerHand.printDeck();

        //check player hand value after dealing 2 cards at the beginning of the game.
        System.out.println("\nChecking player hand value");
        System.out.println("Player hand value: " + this.deck.CHValue(playerHand));
        System.out.println("Dealer hand value: " + this.deck.CHValue(dealerHand));

        //To continue the game, player choose hit or stay
        while (deck.CHValue(player.getHand()) <= 21) { //While player hand < 21

            System.out.println("\nWould you like to 'hit' or 'stay'?");
            String choice = (input.nextLine()); //console input here

            //--------------------------------------------------------------------------
            //when player choose hit
            if (choice.equalsIgnoreCase("hit")) { //if choice not case sensitive: 'hit'

                System.out.println("*****************************************************");
                deck.deal(1, player.getHand()); //deal 1 card to player

                //display cards in hand after player hit
                System.out.println("\nPlayer draw a card, cards in the player's hands after hit: ");
                playerHand.printDeck();//cards in player hand
                System.out.println("Cards in the dealer's hands: ");
                dealerHand.printDeck();//cards in dealer hand

                //check player hand value and dealer hand value
                System.out.println("\nPlayer hand value: " + deck.CHValue(player.getHand()));
                System.out.println("Dealer hand value: " + deck.CHValue(dealer.getHand()));

                //if player's hand value is 21 or greater than 21, declare the winner
                if (deck.CHValue(player.getHand()) > 21) { //If player hand value > 21; declareWinner: dealer
                    declareWinner(dealer);
                    break; //stop while loop
                } else if (deck.CHValue(player.getHand()) == 21) { //If player hand == 21; declareWinner: player
                    declareWinner(player);
                    break;
                }
            } //hit ends
            //---------------------------------------------------------------------------
            //when player choose stay
            else if (choice.equalsIgnoreCase("stay")) { //If choice not case sensitive: 'stay'

                //when dealer hand value is less than 17, dealer choose hit automatically, otherwise exit the loop
                while (deck.CHValue(dealer.getHand()) < 17) { //makes dealer draw if dealer hand value < 17

                    System.out.println("*****************************************************");
                    deck.deal(1, dealer.getHand());

                    //display cards in hand after player hit
                    System.out.println("\nCards in the player's hands: ");
                    playerHand.printDeck();//cards in player hand
                    System.out.println("Dealer draws a card, cards in the dealer's hands after hit: ");
                    dealerHand.printDeck();//cards in dealer hand

                    //check player hand value and dealer hand value
                    System.out.println("\nPlayer hand value: " + deck.CHValue(player.getHand()));
                    System.out.println("Dealer hand value: " + deck.CHValue(dealer.getHand()));
                }

                //both dealer and player does not choose hit anymore, compare dealer and player's hand values.
                if (((deck.CHValue(dealer.getHand())) > 21) || (deck.CHValue(player.getHand()) > deck.CHValue(dealer.getHand()))) {
                    //if dealer hand value is greater than 21 ,or if player hand value is greater than dealer hand value; declareWinner: player
                    declareWinner(player);
                    break; //stop while loop               
                } else if (deck.CHValue(player.getHand()) == deck.CHValue(dealer.getHand())) { //if player hand value == dealer hand value; declareWinner: null
                    declareWinner(null);  // a tie, no winner
                    break; //stop while loop
                } else {
                    declareWinner(dealer);//dealer win
                    break; //stop while loop
                }
            } //stay ends
        } //while loop ends here
    } //play() ends here

    @Override
    public void declareWinner(Player person) {
        if (person == null) {
            System.out.println("Dealer and player are the same! Push!");
        } else {
            System.out.println("\nThe " + person.getName() + " has won the game!");
        }
    }
}
