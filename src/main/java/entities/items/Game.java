package entities.items;

/**
 * Game.
 */
public class Game extends Item {
    private final int playersMin;
    private final int playersMax;

    public Game(int id, String title, int price, int playersMin, int playersMax) {
        super(id, title, price);
        this.playersMin = playersMin;
        this.playersMax = playersMax;
    }

    public int getPlayersMin() {
        return playersMin;
    }

    public int getPlayersMax() {
        return playersMax;
    }

    /**
     * Returns a string representation of the object.
     *
     * @cpu O()
     * @ram O()
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return "Game{" + super.toString() + ", playersMin=" + playersMin + ", playersMax=" + playersMax + "}";
    }
}
