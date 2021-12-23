package entities.items;

/**
 * Book.
 */
public class Book extends Item {
    private final String author;
    private final int pages;

    public Book(final int id, final String title, final int price, final String author, final int pages) {
        super(id, title, price);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
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
        return "Book{" + super.toString() + ", author='" + author + "', pages=" + pages + "}";
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
    public boolean equals(final Book that) {
        return super.equals(that) && pages == that.pages
                && (author != null && author.equals(that.author) || author == null && that.author == null);
    }
}
