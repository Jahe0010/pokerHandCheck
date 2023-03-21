package hand;

import card.CARD_SUITE;
import card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Hand {
    List<Card> hand;

    public Hand(Card card, Card card1, Card card2, Card card3, Card card4) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(card);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        Collections.sort(cards);
        this.hand = cards;
    }

    public String getHandValue() {
        if(hasRoyalFlush()) {
            return "has royal flush";
        }
        else if(hasStraightFlush()) {
            return "straight flush";
        }
        else if(hasFourOfAKind()) {
            return "has four of a kind";
        }
        else if(hasFullHouse()){
            return "has fullhouse";
        }
        else if(hasFlush()) {
            return "has flush";
        }
        else if(hasStraight()) {
            return "has straight";
        }
        else if(hasThreeOfAKind()) {
            return "has three of a kind";
        }
        else if(hasTwoPair()) {
            return "has two pair";
        }
        else if(hasPair()){
            return "pair";
        }
        return hand.get(5).toString();
    }

    /**
     * check if there is at least one pair
     * @return
     */
    private boolean hasPair(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card3 = this.hand.get(2).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return (card1 == card2 && card2 != card3) ||
                (card2 == card3 && card3 != card4 && card2 != card1) ||
                (card3 == card4 && card4 != card5 && card3 != card2) ||
                (card4 == card5 && card4 != card3);
    }

    /**
     * check if we have two pairs
     * @return
     */
    private boolean hasTwoPair(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card3 = this.hand.get(2).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return ((card1 == card2 && card3 == card4 && card2!=card3 && card4 != card5) ||
                (card1 != card2 && card2 == card3 && card3 != card4 && card4 == card5)
        );
    }

    /**
     * check if has three of a kind
     * @return
     */
    private boolean hasThreeOfAKind(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card3 = this.hand.get(2).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return (card1 == card3 && card4 != card5 || card2 == card4 || card3 == card5 && card1 != card2);
    }

    /**
     * check if we have a straight
     * @return
     */
    private boolean hasStraight(){
        return isStraight();
    }

    /**
     * check if we have a flush
     * @return
     */
    private boolean hasFlush(){
        return isFlush();
    }

    /**
     * check if we have a full house
     * @return
     */
    private boolean hasFullHouse(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card3 = this.hand.get(2).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return (card1 == card3 && card4 == card5 || card1 == card2 || card3 == card5);
    }

    /**
     * check if it is a four of a kind
     * @return
     */
    private boolean hasFourOfAKind(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return (card1 == card4 || card2 == card5);
    }

    /**
     * check if we have a straightFlush
     * @return
     */
    private boolean hasStraightFlush(){
        return isFlush() && isStraight();
    }

    /**
     * check if we have a royalFlush
     * @return
     */
    private boolean hasRoyalFlush(){
        if(hasFlush()){
            if(hasStraight()) {
                return this.hand.get(5).getCardValue() == 14;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Determines if its a Straight or not
     * @return
     */
    private boolean isStraight() {
        List<Integer> valueList = hand.stream().map(Card::getCardValue).toList();
        return Collections.max(valueList) - Collections.min(valueList) == 5;
    }

    /**
     * Determines if its a flush or not
     * @return
     */
    private boolean isFlush(){
        String card1 = String.valueOf(this.hand.get(0).getCardSuite());
        String card2 = String.valueOf(this.hand.get(1).getCardSuite());
        String card3 = String.valueOf(this.hand.get(2).getCardSuite());
        String card4 = String.valueOf(this.hand.get(3).getCardSuite());
        String card5 = String.valueOf(this.hand.get(4).getCardSuite());

        return (Objects.equals(card1, card2) && Objects.equals(card2, card3) && Objects.equals(card3, card4) && Objects.equals(card4, card5));
    }
}
