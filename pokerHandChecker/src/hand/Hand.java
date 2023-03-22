package hand;
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

    /**
     * just returns the highest card value
     * Its for the high card check
     * @return
     */
    public Integer getHighestCard() {
        return this.hand.get(4).getCardValue();
    }

    /**
     * just returns a flat list of the card values on your hand
     * @return
     */
    public List<Integer> getCardValues() { return this.hand.stream().map(Card::getCardValue).collect(Collectors.toList());}

    /**
     * returns the most frequents value in the hand
     * @return
     */
    public List<Integer> getMostFrequentValues () {
        return mostFrequentsChecker(this.getCardValues());
    }

    /**
     * returns the most frequent value in the hand
     * @return
     */
    public Integer getMostFrequentValue() { return mostFrequentChecker(this.getCardValues()); }

    /**
     * the order of the ifs show the height of the mapping
     * @return
     */
    public HAND_RANK getHandValue() {
        if(hasRoyalFlush()) {
            return HAND_RANK.royalFlush;
        }
        else if(hasStraightFlush()) {
            return HAND_RANK.straightFlush;
        }
        else if(hasFourOfAKind()) {
            return HAND_RANK.fourOfAKind;
        }
        else if(hasFullHouse()){
            return HAND_RANK.fullhouse;
        }
        else if(hasFlush()) {
            return HAND_RANK.flush;
        }
        else if(hasStraight()) {
            return HAND_RANK.straight;
        }
        else if(hasThreeOfAKind()) {
            return HAND_RANK.threeOfAKind;
        }
        else if(hasTwoPair()) {
            return HAND_RANK.twoPair;
        }
        else if(hasPair()){
            return HAND_RANK.onePair;
        }
        return HAND_RANK.highCard;
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
                return this.hand.get(4).getCardValue() == 14;
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
        return Collections.max(valueList) - Collections.min(valueList) == 4;
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

    /**
     * Checks which number in a hand is the most frequent one and returns its value
     * this is important if we have two flushs because than the highest three of a kind wins
     * @return
     */
    private List<Integer> mostFrequentsChecker(List<Integer> cardValues) {
        int n = cardValues.size();
        int max_count = 0;
        List<Integer> maxfreq = new ArrayList<Integer>();

        for (int i = 0; i < n; i++){
            int count = 0;
            for (Integer cardValue : cardValues) {
                if (Objects.equals(cardValues.get(i), cardValue)) {
                    count++;
                }
            }

            if (count > max_count){
                max_count = count;
                maxfreq.add(cardValues.get(i));
            }
        }
        return maxfreq;
    }

    /**
     * returns a single most frequent for fullhouse
     * @param cardValues
     * @return
     */
    private Integer mostFrequentChecker(List<Integer> cardValues) {
        int n = cardValues.size();
        int max_count = 0;
        int maxfreq = 0;

        for (int i = 0; i < n; i++){
            int count = 0;
            for (Integer cardValue : cardValues) {
                if (Objects.equals(cardValues.get(i), cardValue)) {
                    count++;
                }
            }

            if (count > max_count){
                max_count = count;
                maxfreq = cardValues.get(i);
            }
        }
        return maxfreq;
    }
}
