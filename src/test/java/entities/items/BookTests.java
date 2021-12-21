package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTests {
    @Nested
    public class GetAuthorTest {
        @Test
        public void shouldReturnValueOfAuthorWhenCalled() {
            final Book book = new Book(1, "title", 10, "author", 30);
            Assertions.assertEquals("author", book.getAuthor());
        }
    }

    @Nested
    public class GetPagesTest {
        @Test
        public void shouldReturnValueOfPagesWhenCalled() {
            final Book book = new Book(1, "title", 10, "author", 30);
            Assertions.assertEquals(30, book.getPages());
        }
    }

    @Nested
    public class ToStringTest {
        @Test
        public void shouldReturnStringWhenFieldsHasNotDefaultValues() {
            final Book book = new Book(1, "title", 10, "author", 30);
            final String expected = "Book{Item{id=1, title='title', price=10}, author='author', pages=30}";
            final String actual = book.toString();
            Assertions.assertEquals(expected, actual);
        }
    }
}