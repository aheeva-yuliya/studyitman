package entities.items;

/**
 * Item.
 */
public class Item {
    private final int id;
    private final String title;
    private final int price;

    public Item(final int id, final String title, final int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
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
        return "Item{id=" + id + ", title='" + title + "', price=" + price + "}";
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
    public boolean equals(final Item that) {
        return that != null && id == that.id && price == that.price
                && (title != null && title.equals(that.title) || title == null && that.title == null);
    }
}
