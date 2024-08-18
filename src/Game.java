
import java.util.ArrayList;
import java.util.List;


public abstract class Game {


    protected Deck deck;
    protected List<Player> players;
    protected int currentPlayerIndex;

    protected List<Rule> rules;

    protected int playingDirection;

    protected ArrayList<Card> discardPile;


    public Game() {
        this.playingDirection = 1;
        this.discardPile = new ArrayList<>();
        this.players = new ArrayList<>();
        this.rules = new ArrayList<>();

    }


    public abstract void initializeGame();

    public abstract void play() ;

    public abstract boolean isGameOver();

    public abstract Card getCardFromDeck() ;



    public void applyRule(Card card) {
        for (Rule rule : rules) {
            rule.apply(this, card);
        }
    }

    public void addPlayer(Player player) {
        if(player == null)
            throw new IllegalArgumentException();
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + playingDirection) % players.size();

        if (currentPlayerIndex < 0)
            currentPlayerIndex += players.size();
    }

    public void addRule(Rule rule) {
        if(rule == null)
            throw new IllegalArgumentException();

        rules.add(rule);
    }


}
