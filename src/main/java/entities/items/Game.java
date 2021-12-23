package entities.items;

/**
 * Game.
 */
public class Game extends Item {
    private final int playersMin;
    private final int playersMax;

    public Game(final int id, final String title, final int price, final int playersMin, final int playersMax) {
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

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param that the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(final Game that) {
        return super.equals(that) && playersMin == that.playersMin && playersMax == that.playersMax;
    }
}
