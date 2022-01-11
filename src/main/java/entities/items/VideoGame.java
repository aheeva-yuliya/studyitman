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
     * @cpu O(k + l + m + p + q + t) k - number of chars at the field "id", l - number of chars at the field "title",
     *      m - number of chars at the field "price", p - number of chars at the field "playersMin",
     *      q - number of chars at the field "playersMax", t -  number of chars at the field "platform"
     * @ram O(k + l + m + p + q + t) k - number of chars at the field "id", l - number of chars at the field "title",
     *      m - number of chars at the field "price", p - number of chars at the field "playersMin",
     *      q - number of chars at the field "playersMax", t -  number of chars at the field "platform"
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return "VideoGame{" + super.toString() + ", platform='" + platform + "'}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(l + t) l - number of chars at the field "title", t -  number of chars at the field "platform"
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
        final VideoGame that = (VideoGame) obj;
        return super.equals(that)
                && (platform != null && platform.equals(that.platform) || platform == null && that.platform == null);
    }
}
