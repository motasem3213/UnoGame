import java.util.List;


public class WildDrawFourRule implements Rule {

    @Override
    public void apply(Game game, Card playedCard) {

        if (playedCard.getType() == Card.Type.WILD_DRAW_FOUR) {

            List<Card> hand = game.getCurrentPlayer().getHand();
            boolean isValid = true;
            for (Card card : hand) {
                if (card.getColor() == playedCard.getColor() && card.getType() != Card.Type.WILD_DRAW_FOUR) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Decide next playing color (Enter full color name): ");

                Card.Color color = GetUserInput.getColor();

                game.discardPile.addLast(new Card(color, playedCard.getType(), -1));

                game.getCurrentPlayer().playCard(playedCard);

                game.nextPlayer();

                game.getCurrentPlayer().drawCard(game.getCardFromDeck());
                game.getCurrentPlayer().drawCard(game.getCardFromDeck());
                game.getCurrentPlayer().drawCard(game.getCardFromDeck());
                game.getCurrentPlayer().drawCard(game.getCardFromDeck());

            }


        }
    }
}
