import java.util.Collections;

public class UnoCardDeck extends Deck {

    public UnoCardDeck() {
        initializeDeck();
        shuffle();
    }


    @Override
    public void initializeDeck() {

        // Initialize standard Uno deck with number and action cards
        for (Card.Color color : Card.Color.values()) {
            if (color == Card.Color.WILD) continue; // Skip wild

            for (int i = 0; i <= 9; i++) {
                cards.add(new Card(color, Card.Type.NUMBER, i));
                if (i != 0) cards.add(new Card(color, Card.Type.NUMBER, i));
            }

            cards.add(new Card(color, Card.Type.SKIP, -1));
            cards.add(new Card(color, Card.Type.SKIP, -1));
            cards.add(new Card(color, Card.Type.REVERSE, -1));
            cards.add(new Card(color, Card.Type.REVERSE, -1));
            cards.add(new Card(color, Card.Type.DRAW_TWO, -1));
            cards.add(new Card(color, Card.Type.DRAW_TWO, -1));
        }

        // Add wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(Card.Color.WILD, Card.Type.WILD, -1));
            cards.add(new Card(Card.Color.WILD, Card.Type.WILD_DRAW_FOUR, -1));
        }
    }

    @Override
    public void shuffle() {

        Collections.shuffle(cards);

    }


    @Override
    public Card drawCard() {

        return cards.removeFirst();
    }

}
