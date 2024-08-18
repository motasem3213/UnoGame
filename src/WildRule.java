
public class WildRule implements Rule {

    @Override
    public void apply(Game game, Card playedCard) {
        if (playedCard.getType() == Card.Type.WILD) {
            System.out.println("Choose the Color to continue with : ");

            Card.Color color = GetUserInput.getColor();

            game.discardPile.addLast(new Card(color, Card.Type.WILD, -1));
            game.getCurrentPlayer().playCard(playedCard);

        }
    }


}
