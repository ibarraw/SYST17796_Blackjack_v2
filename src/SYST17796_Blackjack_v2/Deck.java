package SYST17796_Blackjack_v2;

/**
 * This class is used to create Black Jack deck.
 *
 * @author Xianjun Wang July 2021
 * @modifier Chun Kiu So July 2021
 * @modifier William Ibarra July 2021
 */
public class Deck extends GroupOfCards {

    //Bulid a BlackJack Card deck
    public Deck () {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int x = 0; x < Value.values().length; x++) {
                cards.add(new BlackJackCard(Suit.values()[i], Value.values()[x]));
            }
        }
        //Shuffle the deck
        shuffle();
    }

    //Deal cards to the dealer or the players. The number of cards dealed will be depend 
    //on the situaiton including starting the game, hit, stay.
    public void deal (int howMany, GroupOfCards hand) {
        //GroupOfCards checkRecipient = new GroupOfCards();
        int high = cards.size() - 1;
        int low = high - howMany;
        for (int i = high; i > low; --i) {
            hand.addCard(cards.get(i));
            cards.remove(i);
        }
    }

    //This will return an int representation of the sum of all the cards in the dealer or players hands depending on which is passed in.
    public int CHValue (GroupOfCards hands) {
        int total = 0;
        int[] array = new int[hands.getSize()];
        for (int i = 0; i < array.length; i++) {
            array[i] = hands.cards.get(i).value.getNumValue();
            total += array[i];
        }
        //The ace card can have a value of 1 or 11 depending on the hand's total value.
        //If the total hand value is less than 12 and there is an ace in the hand, the value of the ace is 11.
        //If the total hand value is greater than or equal to 12 and there is an ace in the hand, the value of the ace is 1.
        int aceBonus = 0;
        for (int i = 0; i < array.length; i++) { 
            if (hands.cards.get(i).value.getNumValue() == 1 && total < 12) {
                aceBonus = 10;
            }
            if (hands.cards.get(i).value.getNumValue() == 1 && total >= 12) {
                aceBonus = 0;
            }
        }
        return total + aceBonus;

    }

}
