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
     * @cpu O(k + l + m + p + q) k - number of chars at the field "id", l - number of chars at the field "title",
     *      m - number of chars at the field "price", p - number of chars at the field "playersMin",
     *      q - number of chars at the field "playersMax"
     * @ram O(k + l + m + p + q) k - number of chars at the field "id", l - number of chars at the field "title",
     *      m - number of chars at the field "price", p - number of chars at the field "playersMin",
     *      q - number of chars at the field "playersMax"
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return "Game{" + super.toString() + ", playersMin=" + playersMin + ", playersMax=" + playersMax + "}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(l) - number of chars at the field "title"
     * @ram O(1)
     *
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final Game that = (Game) obj;
        return super.equals(that) && playersMin == that.playersMin && playersMax == that.playersMax;
    }
}
