package winner;

import card.Card;
import hand.Hand;

import java.util.List;

public class Winner {
    private Hand hand1;
    private Hand hand2;

    public Winner(Hand hand1, Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public String whoWon(){
        return hand1.getHandValue();
    }
}
