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
     * @cpu O(k + l + m) k - number of chars at the field "id", l - number of chars at the field "title",
     *                   m - number of chars at the field "price"
     * @ram O(k + l + m) k - number of chars at the field "id", l - number of chars at the field "title",
     *                   m - number of chars at the field "price")
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return "Item{id=" + id + ", title='" + title + "', price=" + price + "}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(l) l - number of chars at the field "title"
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
        final Item that = (Item) obj;
        return id == that.id && price == that.price
                && (title != null && title.equals(that.title) || title == null && that.title == null);
    }
}
