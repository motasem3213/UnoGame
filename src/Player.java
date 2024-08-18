import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public void playCard(Card card) {
        hand.remove(card);
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public List<Card> getHand() {
        return hand;
    }

    private void printCardsInHand() {
        int tmp = 0;

        for (Card card : hand) {
            System.out.println(tmp++ + " - " + card.toString());
        }
    }

    public Card play() {

        printOptions();

        int choice = GetUserInput.getNumberInRange(0, hand.size());

        if (choice == hand.size()) {
            return null;
        }
        return hand.get(choice);
    }

    public Card playWithNoDrawCard() {
        printCardsInHand();
        System.out.println(hand.size() + " - If you don't want to draw a card");

        int choice = GetUserInput.getNumberInRange(0, hand.size());
        if (choice == hand.size())
            return null;
        return hand.get(choice);
    }

    private void printOptions() {

        printCardsInHand();
        System.out.println(hand.size() + " - Draw a card from the pile.");
    }

    @Override
    public String toString() {
        return name + " has " + hand.size() + " cards.";
    }
}
