package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ItemTests {
    @Nested
    public class GetIdTest {
        @Test
        public void shouldReturnValueOfIdWhenCalled() {
            final Item item = new Item(1, "title", 10);
            Assertions.assertEquals(1, item.getId());
        }
    }

    @Nested
    public class GetTitleTest {
        @Test
        public void shouldReturnValueOfTitleWhenCalled() {
            final Item item = new Item(1, "title", 10);
            Assertions.assertEquals("title", item.getTitle());
        }
    }

    @Nested
    public class GetPriceTest {
        @Test
        public void shouldReturnValueOfPriceWhenCalled() {
            final Item item = new Item(1, "title", 10);
            Assertions.assertEquals(10, item.getPrice());
        }
    }

    @Nested
    public class ToStringTest {
        @Test
        public void shouldReturnStringWhenFieldsHasNotDefaultValues() {
            final Item item = new Item(1, "title", 10);
            final String expected = "Item{id=1, title='title', price=10}";
            final String actual = item.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void shouldReturnTrueWhenAllFieldsTheSame() {
            final Item item1 = new Item(1, "title", 10);
            final Item item2 = new Item(1, "title", 10);
            Assertions.assertEquals(item1, item2);
        }

        @Test
        public void shouldReturnFalseWhenStringFieldsDifferent() {
            final Item item1 = new Item(1, "title", 10);
            final Item item2 = new Item(1, "tile", 10);
            Assertions.assertNotEquals(item1, item2);
        }

        @Test
        public void shouldReturnFalseWhenThatIsNull() {
            final Item item1 = new Item(1, "title", 10);
            Assertions.assertNotEquals(item1, null);
        }
    }
}