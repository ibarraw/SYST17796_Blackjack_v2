package SYST17796_Blackjack_v2;

/**
 * This class This class is used to models BlackJack card Objects. A BlackJack
 * card has a value among: ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
 * TEN, JACK, QUEEN, KING and it has a suit among: CLUB, SPADE, DIAMOND, HEART
 * All together there are 52 cards in a deck.
 *
 * @author Xianjun Wang July 2021
 */
public class BlackJackCard extends Card {

    //BlackJackCard constructor
    public BlackJackCard(Suit suit, Value value) {
        super(suit, value);
    }

    //Print BlackJack Card value and suit.
    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
