public class UnoGame extends Game {

    public UnoGame() {
        super();
        this.deck = new UnoCardDeck();

        addRule(new ChangeDirectionRule());
        addRule(new SkipTurnRule());
        addRule(new SameColorRule());
        addRule(new SameNumberRule());
        addRule(new WildDrawFourRule());
        addRule(new WildRule());
        addRule(new DrawTwoRule());

    }

    @Override
    public void initializeGame() {

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(getCardFromDeck());
            }
        }

        do {
            discardPile.add(deck.drawCard());
        } while (discardPile.getLast().getType() == Card.Type.WILD);

    }

    @Override
    public void play() {

        initializeGame();

        while (!isGameOver()) {

            Player currentPlayer = getCurrentPlayer();

            System.out.println("Last Played Card : " + discardPile.getLast().toString());

            System.out.println(currentPlayer.getName() + "'s turn");


            Card playedCard = currentPlayer.play();


            if (playedCard == null) {
                currentPlayer.drawCard(getCardFromDeck());

                playedCard = currentPlayer.playWithNoDrawCard();
            }

            if (playedCard != null)
                applyRule(playedCard);


            nextPlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        for (Player player : players) {
            if (player.hasWon()) {
                System.out.println(player.getName() + " has won the game!");
                return true;
            }
        }
        return false;
    }

    @Override
    public Card getCardFromDeck() {

        if (deck.isEmpty()) {
            Card lastCard = discardPile.getLast();
            discardPile.removeLast();
            for (Card card : discardPile) {

                if (card.getType() == Card.Type.WILD) {
                    deck.addCard(new Card(Card.Color.WILD, Card.Type.WILD, -1));
                } else if (card.getType() == Card.Type.WILD_DRAW_FOUR) {
                    deck.addCard(new Card(Card.Color.WILD, Card.Type.WILD_DRAW_FOUR, -1));

                } else
                    deck.addCard(card);
            }

            discardPile.clear();
            discardPile.add(lastCard);
        }

        return deck.drawCard();
    }
}
