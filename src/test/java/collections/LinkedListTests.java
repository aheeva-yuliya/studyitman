package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LinkedListTests {
    @Nested
    public class Add {
        @Test
        public void shouldAddFirstWhenListEmptyAndWhenHasSomeElements() {
            LinkedList list = new LinkedList();
            list.addFirst(7);
            Assertions.assertEquals(7, list.getFirst());
            list.addFirst(55);
            Assertions.assertEquals(55, list.getFirst());
            list.addFirst(51);
            Assertions.assertEquals(51, list.getFirst());
        }

        @Test
        public void shouldAddLastWhenListNotEmpty() {
            LinkedList list = new LinkedList();
            list.addLast(7);
            list.addFirst(55);
            list.addLast(51);
            list.addLast(100);
            String expected = "[55, 7, 51, 100]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldAddLastWhenListEmpty() {
            LinkedList list = new LinkedList();
            list.addLast(100);
            String expected = "[100]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Get {
        @Test
        public void shouldGetFirstWhenListContainsOneElement() {
            LinkedList list = new LinkedList();
            list.addFirst(7);
            Assertions.assertEquals(7, list.getFirst());
        }

        @Test
        public void shouldGetLastWhenListContainsSomeElements() {
            LinkedList list = LinkedList.of(7, 55, 51, 100);
            Assertions.assertEquals(100, list.getLast());
            String expected = "[7, 55, 51, 100]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldGetWhenTryGetFromIndex() {
            LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
            Assertions.assertEquals(14, list.get(2));
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveFirstWhenListContainsSomeElements() {
            LinkedList list = LinkedList.of(51, 55, 7);
            Assertions.assertEquals(51, list.removeFirst());
            Assertions.assertEquals(55, list.getFirst());
            Assertions.assertEquals("[55, 7]", list.toString());
        }

        @Test
        public void shouldRemoveFirstWhenListContainsOneElement() {
            LinkedList list = new LinkedList();
            list.addFirst(7);
            Assertions.assertEquals(7, list.removeFirst());
            Assertions.assertEquals("[]", list.toString());
        }

        @Test
        public void shouldRemoveLastWhenListContainsSomeElements() {
            LinkedList list = LinkedList.of(51, 55, 7);
            Assertions.assertEquals(7, list.removeLast());
            Assertions.assertEquals("[51, 55]", list.toString());
        }

        @Test
        public void shouldRemoveLastWhenListContainsTwoElements() {
            LinkedList list = LinkedList.of(55, 7);
            Assertions.assertEquals(7, list.removeLast());
            Assertions.assertEquals("[55]", list.toString());
        }

        @Test
        public void shouldRemoveLastWhenListContainsOneElement() {
            LinkedList list = LinkedList.of(7);
            Assertions.assertEquals(7, list.removeLast());
            Assertions.assertEquals("[]", list.toString());
        }


        @Test
        public void shouldRemoveWhenTryRemoveFromTheMiddle() {
            LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
            Assertions.assertEquals(14, list.remove(2));
            Assertions.assertEquals("[12, 13, 15, 16]", list.toString());
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromFirstIndex() {
            LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
            Assertions.assertEquals(12, list.remove(0));
            Assertions.assertEquals("[13, 14, 15, 16]", list.toString());
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromLastIndex() {
            LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
            Assertions.assertEquals(16, list.remove(4));
            Assertions.assertEquals("[12, 13, 14, 15]", list.toString());
        }

        @Test
        public void shouldRemoveWhenTryRemoveFromTheMiddleIndex() {
            LinkedList list = LinkedList.of(10, 20, 30);
            Assertions.assertEquals(20, list.remove(1));
            Assertions.assertEquals("[10, 30]", list.toString());
            Assertions.assertEquals(2, list.size());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldMakeStringWhenListNotEmpty() {
            LinkedList list = LinkedList.of(51, 55, 7);
            String expected = "[51, 55, 7]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldMakeStringWhenListContainsOneNode() {
            LinkedList list = new LinkedList();
            list.addFirst(7);
            String expected = "[7]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldMakeStringWhenListEmpty() {
            LinkedList list = new LinkedList();
            String expected = "[]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Create {
        @Test
        public void shouldCreateLinkedListWhenTryCreateOfThatList() {
            LinkedList list = LinkedList.of(11, 12, 13);
            LinkedList copy = new LinkedList(list);
            Assertions.assertEquals("[11, 12, 13]", copy.toString());
        }

        @Test
        public void shouldCreateLinkedListWhenThatContainsOneNode() {
            LinkedList list = LinkedList.of(11);
            LinkedList copy = new LinkedList(list);
            Assertions.assertEquals("[11]", copy.toString());
        }

        @Test
        public void shouldCreateLinkedListWhenThatEmpty() {
            LinkedList list = new LinkedList();
            LinkedList copy = new LinkedList(list);
            Assertions.assertEquals("[]", copy.toString());
        }

        @Test
        public void shouldCreateWhenTryCreateOfSomeElements() {
            LinkedList list = LinkedList.of(67, 78, 94, 100, 33);
            String expected = "[67, 78, 94, 100, 33]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldCreateWhenTryCreateOfEmpty() {
            LinkedList list = LinkedList.of();
            String expected = "[]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldMakeArrayWhenListContainsSomeElements() {
            LinkedList list = LinkedList.of(11, 12, 13);
            int[] expected = new int[]{11, 12, 13};
            int[] actual = list.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldMakeArrayWhenListEmpty() {
            LinkedList list = new LinkedList();
            int[] expected = new int[]{};
            int[] actual = list.toArray();
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    public class Set {
        @Test
        public void shouldSetWhenTrySetAtIndex() {
            LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
            list.set(2, 100);
            String expected = "[12, 13, 100, 15, 16]";
            String actual = list.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnFiveWhenListContainsFiveNodes() {
            LinkedList list = LinkedList.of(12, 13, 14, 15, 16);
            Assertions.assertEquals(5, list.size());
        }

        @Test
        public void shouldReturnSizeWhenTryAddAndRemove() {
            LinkedList list = new LinkedList();
            Assertions.assertEquals(0, list.size());
            list.addFirst(7);
            Assertions.assertEquals(1, list.size());
            list.addLast(5);
            Assertions.assertEquals(2, list.size());
            list.removeLast();
            Assertions.assertEquals(1, list.size());
            list.removeFirst();
            Assertions.assertEquals(0, list.size());
        }

        @Test
        public void shouldReturnZeroWhenListEmpty() {
            LinkedList list = new LinkedList();
            Assertions.assertEquals(0, list.size());
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenListsContainSameElements() {
            LinkedList a = LinkedList.of(12, 13, 14, 15, 16);
            LinkedList b = LinkedList.of(12, 13, 14, 15, 16);
            Assertions.assertTrue(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenListsContainDifferentElements() {
            LinkedList a = LinkedList.of(12, 13, 14, 15, 16);
            LinkedList b = LinkedList.of(12, 13, 100, 15, 16);
            Assertions.assertFalse(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenListsHaveDifferentLengths() {
            LinkedList a = LinkedList.of(12, 13, 14, 15, 16);
            LinkedList b = LinkedList.of(12, 13, 14, 15, 16, 17);
            Assertions.assertFalse(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenThisEmpty() {
            LinkedList a = new LinkedList();
            LinkedList b = LinkedList.of(12, 13, 100, 15, 16);
            Assertions.assertFalse(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenThatEmpty() {
            LinkedList a = new LinkedList();
            LinkedList b = LinkedList.of(12, 13, 100, 15, 16);
            Assertions.assertFalse(b.equals(a));
        }

        @Test
        public void shouldReturnTrueWhenBothEmpty() {
            LinkedList a = new LinkedList();
            LinkedList b = new LinkedList();
            Assertions.assertTrue(a.equals(b));
        }

        @Test
        public void shouldReturnFalseWhenThatNull() {
            LinkedList a = new LinkedList();
            Assertions.assertFalse(a.equals(null));
        }
    }
}