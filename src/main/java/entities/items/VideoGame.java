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
}
