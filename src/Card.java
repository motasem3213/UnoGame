public class Card {
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String yellow = "\u001B[33m";
    String blue = "\u001B[34m";

    public enum Color {
        RED, YELLOW, GREEN, BLUE, WILD
    }

    public enum Type {
        NUMBER, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR
    }

    private final Color color;
    private final Type type;
    private final int value; // Only for number cards

    public Card(Color color, Type type, int value) {
        this.color = color;
        this.type = type;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {

        switch (color) {
            case RED -> {
                return red + color + " " + value + " " + type + reset;
            }
            case GREEN -> {
                return green + color + " " + value + " " + type + reset;
            }
            case BLUE -> {
                return blue + color + " " + value + " " + type + reset;
            }
            case YELLOW -> {
                return yellow + color + " " + value + " " + type + reset;
            }
            case WILD -> {
                return red + color + reset + " " + green + value + reset + " " + blue + type + reset;
            }
        }

        return color + " " + value + " " + type;

    }
}
