import card.CARD_SUITE;
import card.Card;
import hand.Hand;
import winner.Winner;

// card Values: 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
// card values for me: 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
// TODO: Achtung: ass kann 14 und 1 sein! bitte richtig mappen
public class Main {

    // two royalFlush
    public static final Hand RoyalFlush1 =  new Hand(new Card(CARD_SUITE.H, 14), new Card(CARD_SUITE.H, 13), new Card(CARD_SUITE.H, 12), new Card(CARD_SUITE.H, 11), new Card(CARD_SUITE.H,10));
    public static final Hand RoyalFlush2 =  new Hand( new Card(CARD_SUITE.D, 14), new Card(CARD_SUITE.D, 13), new Card(CARD_SUITE.D, 12), new Card(CARD_SUITE.D, 11), new Card(CARD_SUITE.D,10));

    // one flush and one four of a kind
    public static final Hand flush1 =  new Hand(new Card(CARD_SUITE.H, 9), new Card(CARD_SUITE.H, 13), new Card(CARD_SUITE.H, 8), new Card(CARD_SUITE.H, 11), new Card(CARD_SUITE.H,10));
    public static final Hand fourOfAKind1 =  new Hand( new Card(CARD_SUITE.H, 5), new Card(CARD_SUITE.D, 5), new Card(CARD_SUITE.S, 5), new Card(CARD_SUITE.C, 5), new Card(CARD_SUITE.D,10));

    // two full house with different values
    public static final Hand fullHouse1 =  new Hand(new Card(CARD_SUITE.H, 9), new Card(CARD_SUITE.D, 9), new Card(CARD_SUITE.S, 9), new Card(CARD_SUITE.H, 5), new Card(CARD_SUITE.C,5));
    public static final Hand fullHouse2 =  new Hand( new Card(CARD_SUITE.H, 10), new Card(CARD_SUITE.D, 10), new Card(CARD_SUITE.S, 8), new Card(CARD_SUITE.C, 8), new Card(CARD_SUITE.D,8));

    // two full house with same pair
    public static final Hand fullHouse3 =  new Hand(new Card(CARD_SUITE.H, 9), new Card(CARD_SUITE.D, 9), new Card(CARD_SUITE.S, 9), new Card(CARD_SUITE.H, 14), new Card(CARD_SUITE.C,14));
    public static final Hand fullHouse4 =  new Hand( new Card(CARD_SUITE.H, 10), new Card(CARD_SUITE.D, 10), new Card(CARD_SUITE.S, 10), new Card(CARD_SUITE.S, 14), new Card(CARD_SUITE.D,14));

    // highcard and pair
    public static final Hand highCard =  new Hand(new Card(CARD_SUITE.H, 14), new Card(CARD_SUITE.D, 9), new Card(CARD_SUITE.S, 7), new Card(CARD_SUITE.H, 3), new Card(CARD_SUITE.C,2));
    public static final Hand pair =  new Hand( new Card(CARD_SUITE.H, 10), new Card(CARD_SUITE.D, 10), new Card(CARD_SUITE.S, 8), new Card(CARD_SUITE.S, 3), new Card(CARD_SUITE.D,4));


    public static void main(String[] args) {
        System.out.println("======= Both Royal Flush both should win. Should be a draw!=======");
        Winner royalFlushWinner = new Winner(RoyalFlush1, RoyalFlush2);
        String royalFlushWon = royalFlushWinner.whoWon();
        System.out.println(royalFlushWon);

        System.out.println("======= One Flush and one four of a Kind. 2nd should win.=======");
        Winner winnerTest2 = new Winner(flush1, fourOfAKind1);
        String test2Won = winnerTest2.whoWon();
        System.out.println(test2Won);

        System.out.println("======= Special case! two full house with different heights!! First should win.=======");
        Winner winnerTest3 = new Winner(fullHouse1, fullHouse2);
        String test3Won = winnerTest3.whoWon();
        System.out.println(test3Won);

        System.out.println("======= Special case! two full house with same two pair heights!! 2nd should win =======");
        Winner winnerTest4 = new Winner(fullHouse3, fullHouse4);
        String test4Won = winnerTest4.whoWon();
        System.out.println(test4Won);

        System.out.println("======= Simple test for highCard and pair!! 2nd should win =======");
        Winner winnerTest5 = new Winner(highCard, pair);
        String test5Won = winnerTest5.whoWon();
        System.out.println(test5Won);
    }
}