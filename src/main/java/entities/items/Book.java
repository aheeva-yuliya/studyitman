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
     * @cpu O(k + l + m + n + o) k - number of chars at the field "id", l - number of chars at the field "title",
     *        m - number of chars at the field "price", n - number of chars at the field "author",
     *        o - number of chars at the field "pages"
     * @ram O(k + l + m + n + o) k - number of chars at the field "id", l - number of chars at the field "title",
     *        m - number of chars at the field "price", n - number of chars at the field "author",
     *        o - number of chars at the field "pages"
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Book{" + super.toString() + ", author='" + author + "', pages=" + pages + "}";
    }


    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @cpu O(l + n) l - number of chars at the field "title", n - number of chars at the field "author"
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
        final Book that = (Book) obj;
        return super.equals(that) && pages == that.pages
                && (author != null && author.equals(that.author) || author == null && that.author == null);
    }
}
