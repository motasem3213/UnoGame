public class ChangeDirectionRule implements Rule {
    @Override
    public void apply(Game game, Card playedCard) {
        if (playedCard.getType() == Card.Type.REVERSE)
            if (game.discardPile.getLast().getColor() == playedCard.getColor() || game.discardPile.getLast().getType() == Card.Type.REVERSE) {
                game.discardPile.addLast(playedCard);

                game.playingDirection *= -1;
            }
    }
}
