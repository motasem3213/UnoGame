public class SameNumberRule implements Rule{

    @Override
    public void apply(Game game, Card playedCard) {
        if(game.discardPile.getLast().getValue() == playedCard.getValue() && playedCard.getValue() != -1)
        {
            game.discardPile.addLast(playedCard);
            game.getCurrentPlayer().playCard(playedCard);
        }
    }
}
