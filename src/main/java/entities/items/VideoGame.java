package entities.items;

/**
 * VideoGame.
 */
public class VideoGame extends Game {
    private final String platform;

    public VideoGame(final int id, final String title, final int price, final int playersMin, final int playersMax,
                     final String platform) {
        super(id, title, price, playersMin, playersMax);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
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
        return "VideoGame{" + super.toString() + ", platform='" + platform + "'}";
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
    public boolean equals(final VideoGame that) {
        return super.equals(that)
                && (platform != null && platform.equals(that.platform) || platform == null && that.platform == null);
    }
}
