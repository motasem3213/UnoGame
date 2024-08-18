public class DrawTwoRule implements Rule {

    @Override
    public void apply(Game game, Card playedCard) {

        if (playedCard.getType() == Card.Type.DRAW_TWO)
            if (playedCard.getType() == game.discardPile.getLast().getType()) {

                game.getCurrentPlayer().playCard(playedCard);
                game.nextPlayer();
                Player nextPlayer = game.getCurrentPlayer();

                System.out.println(nextPlayer.getName() + " draws two cards.");
                nextPlayer.drawCard(game.getCardFromDeck());
                nextPlayer.drawCard(game.getCardFromDeck());


            }

    }


}
