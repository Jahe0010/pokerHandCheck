package winner;

import card.Card;
import hand.HAND_RANK;
import hand.Hand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.Float.sum;

public class Winner {
    private Hand hand1;
    private Hand hand2;

    public Winner(Hand hand1, Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    /**
     * We always return the string with the information which of both hands has one
     * @return
     */
    public String whoWon(){
        /**
         * First we check if they hit the same HandValue (fullHouse, pair, and so on...)
         */
        if(Objects.equals(this.hand1.getHandValue(), this.hand2.getHandValue())){
           /**
            * If its a fullhouse there could be a special case. Because then the highest triple wins
            * four of a kind and three pair can be added to the logic of fullhouse because always the highest combination wins and there is no possibility of the same combination in the same height
            * If its two pair we have to check make a different check!
            * if its one pair we have to check if they are the same.
            */
           if(this.hand1.getHandValue() == HAND_RANK.fourOfAKind || this.hand1.getHandValue() == HAND_RANK.fullhouse || this.hand1.getHandValue() == HAND_RANK.threeOfAKind) {
               if(this.hand1.getHandValue() == HAND_RANK.fullhouse){
                   if(this.hand1.getMostFrequentValue() > this.hand2.getMostFrequentValue()) {
                       return "Hand 1 won!";
                   } else {
                       return "Hand 2 won!";
                   }
               } else if(this.hand1.getMostFrequentValues().get(0) > this.hand2.getMostFrequentValues().get(0)) {
                   return "Hand 1 won!";
               } else {
                   return "Hand 2 won!";
               }
           } else if (this.hand1.getHandValue() == HAND_RANK.twoPair) {
               if(this.hand1.getMostFrequentValues().get(0) > this.hand2.getMostFrequentValues().get(0)) {
                   return "Hand 1 won!";
               } else if(this.hand1.getMostFrequentValues().get(1) > this.hand2.getMostFrequentValues().get(1)) {
                   return "Hand 2 won!";
               } else {
                   if(Collections.max(this.hand1.getCardValues()) < Collections.max(this.hand2.getCardValues())) {
                       return "Hand 1 won!";
                   } else {
                       return "Hand 2 won!";
                   }
               }
           } else if (this.hand1.getHandValue() == HAND_RANK.onePair) {
               if(Objects.equals(this.hand1.getMostFrequentValues().get(0), this.hand2.getMostFrequentValues().get(0))) {
                   if(Collections.max(this.hand1.getCardValues()) < Collections.max(this.hand2.getCardValues())) {
                       return "Hand 1 won!";
                   } else {
                       return "Hand 2 won!";
                   }
               } else if(this.hand1.getMostFrequentValues().get(0) > this.hand2.getMostFrequentValues().get(0)) {
                   return "Hand 1 won!";
               } else {
                   return "Hand 2 won!";
               }
           } else {
               if(Objects.equals(this.hand1.getHighestCard(), this.hand2.getHighestCard())) {
                   return "Draw! No winner yet! Split Pot!";
               } else if(this.hand1.getHighestCard() < this.hand2.getHighestCard()) {
                   return "Hand 1 won!";
               } else {
                   return "Hand 2 won!";
               }
           }
        } else {
            /**
             * Lower hand value wins (its based on the structure from the enum.
             * The enum hast the highest level first and the lowest last. so the lower index of the enum field wins
             */
            if(Arrays.asList(HAND_RANK.values()).indexOf(this.hand1.getHandValue()) < Arrays.asList(HAND_RANK.values()).indexOf(this.hand2.getHandValue())) {
                return "Hand 1 won!";
            } else {
                return "Hand 2 won!";
            }
        }
    }
}
