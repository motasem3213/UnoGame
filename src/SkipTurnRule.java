public class SkipTurnRule implements Rule{
    @Override
    public void apply(Game game, Card playedCard) {
        if(playedCard.getType() == Card.Type.SKIP )
            if(playedCard.getColor() == game.discardPile.getLast().getColor())
            {

                game.discardPile.addLast(playedCard);
                game.getCurrentPlayer().playCard(playedCard);
                game.nextPlayer();
            }
    }
}
