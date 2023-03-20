package hand;

import card.Card;

import java.util.List;

public class Hand {
    List<Card> hand;

    public Hand(Card card, Card card1, Card card2, Card card3, Card card4) {
        this.hand = List.of(card, card1, card2, card3, card4);
    }

    public String getHandValue() {
        if(hasFourOfAKind()) {
            return "has four of a kind";
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
        return "highcard";
    }

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

    private boolean hasThreeOfAKind(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card3 = this.hand.get(2).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return (card1 == card3 || card2 == card4 || card3 == card5);
    }

    private boolean hasFourOfAKind(){
        int card1 = this.hand.get(0).getCardValue();
        int card2 = this.hand.get(1).getCardValue();
        int card3 = this.hand.get(2).getCardValue();
        int card4 = this.hand.get(3).getCardValue();
        int card5 = this.hand.get(4).getCardValue();

        return (card1 == card3 || card2 == card4 || card3 == card5);
    }
}
