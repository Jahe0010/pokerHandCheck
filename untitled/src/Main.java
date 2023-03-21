import card.CARD_SUITE;
import card.Card;
import hand.Hand;
import winner.Winner;

import java.util.List;

// card Values: 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
// card values for me: 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
// achtung: ass kann 14 und 1 sein! bitte richtig mappen
public class Main {
    public static final Hand HAND1 =  new Hand(
            new Card(CARD_SUITE.H, 4),
            new Card(CARD_SUITE.H, 5),
            new Card(CARD_SUITE.H, 4),
            new Card(CARD_SUITE.H, 3),
            new Card(CARD_SUITE.D,5)
    );

    public static final Hand HAND2 =  new Hand(
            new Card(CARD_SUITE.C, 5),
            new Card(CARD_SUITE.D, 13),
            new Card(CARD_SUITE.D, 14),
            new Card(CARD_SUITE.D, 3),
            new Card(CARD_SUITE.S,4)
    );

    public static void main(String[] args) {
        Winner winner = new Winner(HAND1, HAND2);
        String whoWon = winner.whoWon();
        System.out.println(whoWon);
    }
}