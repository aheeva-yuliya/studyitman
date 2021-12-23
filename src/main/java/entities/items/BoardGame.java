package entities.items;

/**
 * BoardGame.
 */
public class BoardGame extends Game {
    private final int timeMin;
    private final int timeMax;

    public BoardGame(final int id, final String title, final int price, final int playersMin, final int playersMax,
                     final int timeMin, final int timeMax) {
        super(id, title, price, playersMin, playersMax);
        this.timeMin = timeMin;
        this.timeMax = timeMax;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public int getTimeMax() {
        return timeMax;
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
        return "BoardGame{" + super.toString() + ", timeMin=" + timeMin + ", timeMax=" + timeMax + "}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(1)
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
        final BoardGame that = (BoardGame) obj;
        return super.equals(that) && timeMin == that.timeMin && timeMax == that.timeMax;
    }
}
