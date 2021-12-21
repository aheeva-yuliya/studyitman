package entities.items;

/**
 * Book.
 */
public class Book extends Item {
    private final String author;
    private final int pages;

    public Book(int id, String title, int price, String author, int pages) {
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
}
