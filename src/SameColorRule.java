public class SameColorRule implements Rule{
    @Override
    public void apply(Game game, Card playedCard) {
        if(game.discardPile.getLast().getColor() == playedCard.getColor())
        {
            game.discardPile.addLast(playedCard);
            game.getCurrentPlayer().playCard(playedCard);
        }
    }
}

