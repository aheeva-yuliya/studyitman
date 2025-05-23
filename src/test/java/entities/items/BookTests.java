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

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTrueWhenAllFieldsTheSame() {
            final Book book1 = new Book(1, "title", 10, "author", 30);
            final Book book2 = new Book(1, "title", 10, "author", 30);
            Assertions.assertEquals(book1, book2);
        }

        @Test
        public void shouldReturnFalseWhenStringFieldsDifferent() {
            final Book book1 = new Book(1, "title", 10, "author", 30);
            final Book book2 = new Book(1, "tile", 10, "author", 30);
            Assertions.assertNotEquals(book1, book2);
        }

        @Test
        public void shouldReturnFalseWhenThatIsNull() {
            final Book book1 = new Book(1, "title", 10, "author", 30);
            Assertions.assertNotEquals(null, book1);
        }
    }
}