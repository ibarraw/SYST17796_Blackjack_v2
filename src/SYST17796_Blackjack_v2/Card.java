package SYST17796_Blackjack_v2;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modifier William Ibarra July 2021
 * @modifier Xianjun Wang July 2021
 * @modifier Chun Kiu So July 2021
 */
public abstract class Card { //default modifier for child classes

    protected Suit suit;
    protected Value value;

    public Card (Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit () {
        return suit;
    }

    public void setSuit (Suit suit) {
        this.suit = suit;
    }

    public Value getValue () {
        return value;
    }

    public void setValue (Value value) {
        this.value = value;
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    @Override
    public abstract String toString ();
}
