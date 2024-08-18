import java.util.ArrayList;
import java.util.List;

public  abstract class Deck {
    protected final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public abstract void initializeDeck() ;
    public abstract void shuffle();
    public abstract Card drawCard() ;

    public void addCard(Card card) {
        if(card == null)
            throw new IllegalArgumentException();

        cards.add(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
