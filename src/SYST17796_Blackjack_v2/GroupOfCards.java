package SYST17796_Blackjack_v2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Xianjun Wang July 2021
 * @modifier Chun Kiu So July 2021
 * @modifier William Ibarra August 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards;

    //New ArrayList creation
    public GroupOfCards () {
        cards = new ArrayList<>();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards () {
        return cards;
    }

    //add cards to the ArrayList
    public void addCard (Card c) {
        cards.add(c);
    }

    //shuffle the cards
    public void shuffle () {
        Collections.shuffle(cards);
    }

    //print all the cards
    public void printDeck () {
        int index = 0;
        for (Card c : cards) {
            index++;
            System.out.println(index + "  " + c);
        }
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize () {
        return cards.size();
    }

}//end class
