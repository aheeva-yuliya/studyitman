package services.calendar;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DynamicEventListTests {
    @Nested
    public class Add {
        @Test
        public void shouldAddWhenValidDate() {
            DynamicEventList list = new DynamicEventList();
            final String expected = "Event has been successfully added.";
            final String actual = list.add(new Event(1991, 9, 8, "birthday"));
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnMessageWhenInvalidDate() {
            DynamicEventList list = new DynamicEventList();
            final String expected = "Invalid event." + "\n"
                    + "\n"
                    + "Valid event example:" + "\n"
                    + "{" + "\n"
                    + "    \"year\" : 2021," + "\n"
                    + "    \"month\" : 9," + "\n"
                    + "    \"day\" : 3," + "\n"
                    + "    \"name\" : " + "\"event\"" + "\n"
                    + "}" + "\n"
                    + "\n"
                    + "Field " + "\"name\"" + " should contain maximum 100 characters.";
            final String actual = list.add(new Event(1991, 8, 8,
                    "birthday birthday birthday birthday birthday birthday birthday birthday birthday birthday" +
                            " birthday birthday birthday party!!!!!!!!"));
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnMessageWhenAddNull() {
            DynamicEventList list = new DynamicEventList();
            final String expected = "Invalid event." + "\n"
                    + "\n"
                    + "Valid event example:" + "\n"
                    + "{" + "\n"
                    + "    \"year\" : 2021," + "\n"
                    + "    \"month\" : 9," + "\n"
                    + "    \"day\" : 3," + "\n"
                    + "    \"name\" : " + "\"event\"" + "\n"
                    + "}" + "\n"
                    + "\n"
                    + "Field " + "\"name\"" + " should contain maximum 100 characters.";
            final String actual = list.add(null);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Set {
        @Test
        public void shouldSetWhenValidDateAndValidId() {
            DynamicEventList list = new DynamicEventList();
            list.add(new Event(1991, 9, 8, "birthday"));
            final String expected = "Event with id#1 has been successfully changed.";
            final String actual = list.set(1, new Event(1992, 9, 8, "birthday"));
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnMessageWhenValidDateAndInvalidId() {
            DynamicEventList list = new DynamicEventList();
            list.add(new Event(1991, 9, 8, "birthday"));
            final String expected = "Event with id#4 has not been found.";
            final String actual = list.set(4, new Event(1992, 9, 8, "birthday"));
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnMessageWhenInvalidDateAndValidId() {
            DynamicEventList list = new DynamicEventList();
            list.add(new Event(1991, 9, 8, "birthday"));
            final String expected = "Invalid event." + "\n"
                    + "\n"
                    + "Valid event example:" + "\n"
                    + "{" + "\n"
                    + "    \"year\" : 2021," + "\n"
                    + "    \"month\" : 9," + "\n"
                    + "    \"day\" : 3," + "\n"
                    + "    \"name\" : " + "\"event\"" + "\n"
                    + "}" + "\n"
                    + "\n"
                    + "Field " + "\"name\"" + " should contain maximum 100 characters.";
            final String actual = list.set(1, new Event(1992, 9, 32, "birthday"));
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveWhenValidId() {
            DynamicEventList list = new DynamicEventList();
            list.add(new Event(1991, 9, 8, "birthday"));
            final String expected = "Event with id#1 has been successfully removed.";
            final String actual = list.remove(1);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnMessageWhenInvalidId() {
            DynamicEventList list = new DynamicEventList();
            list.add(new Event(1991, 9, 8, "birthday"));
            final String expected = "Event with id#4 has not been found.";
            final String actual = list.remove(4);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class EndToEnd {
        @Test
        public void endToEnd() {
            DynamicEventList list = new DynamicEventList();
            list.add(new Event(1991,9,8,"AAa"));
            list.add(new Event(1991,9,8,"Aaa"));
            list.set(1, new Event(1991, 9, 8, "aaa"));
            Event[] expected = new Event[] {
                    new Event(2, 1991,9,8,"Aaa"),
                    new Event(1, 1991, 9, 8, "aaa")};
            Event[] actual = list.getAll();
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(0, actual[i].compareTo(expected[i]));
                Assertions.assertEquals(expected[i].getId(), actual[i].getId());
            }
            list.remove(1);
            expected = new Event[] {new Event(2,1991,9,8,"Aaa")};
            actual = list.getAll();
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(0, actual[i].compareTo(expected[i]));
                Assertions.assertEquals(expected[i].getId(), actual[i].getId());
            }
            list.add(new Event(1991,9,8,"AAA"));
            list.add(new Event(1991,10,8,"AAA"));
            list.add(new Event(1992,10,8,"AAA"));
            expected = new Event[] {
                    new Event(3, 1991,9,8,"AAA"),
                    new Event(2, 1991,9,8,"Aaa")};
            actual = list.getByDate(8, 9, 1991);
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(0, actual[i].compareTo(expected[i]));
                Assertions.assertEquals(expected[i].getId(), actual[i].getId());
            }
            expected = new Event[] {new Event(4, 1991,10,8,"AAA")};
            actual = list.getByMonth(10,1991);
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(0, actual[i].compareTo(expected[i]));
                Assertions.assertEquals(expected[i].getId(), actual[i].getId());
            }
            expected = new Event[] {new Event(5, 1992,10,8,"AAA")};
            actual = list.getByYear(1992);
            for (int i = 0; i < actual.length; i++) {
                Assertions.assertEquals(0, actual[i].compareTo(expected[i]));
                Assertions.assertEquals(expected[i].getId(), actual[i].getId());
            }
        }
    }
}