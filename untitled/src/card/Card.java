package card;

import java.util.Map;

public class Card {
    private final CARD_SUITE cardSuite;
    private final int cardValue;

    public Card(CARD_SUITE suiteValue, int cardValue){
        this.cardSuite = suiteValue;
        this.cardValue = cardValue;
    }

    public CARD_SUITE getCardSuite() {
        return cardSuite;
    }

    public int getCardValue() {
        return cardValue;
    }
}
