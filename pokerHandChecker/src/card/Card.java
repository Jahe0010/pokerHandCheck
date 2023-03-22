package card;

public class Card implements Comparable<Card>{
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

    @Override
    public int compareTo(Card card) {
        return getCardValue() - card.getCardValue();
    }
}
