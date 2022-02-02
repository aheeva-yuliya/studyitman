package services.calendar;

import entities.Event;

/**
 * DynamicEventList.
 */
public class EventArrayList {
    private Event[] array;
    private int size;
    private int id;

    /**
     * Creates an object of DynamicEventList with the length of Event array equals to 16.
     *
     * @cpu O(1)
     * @ram O(1)
     */
    public EventArrayList() {
        array = new Event[16];
    }

    /**
     * Adds the value of the parameter element to the end of the existing array. Creates a new temporary
     *  Event[] and copies all the elements if the instance variables "size" and "array".length are equal.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element an object of Event
     * @return a String with information.
     */
    public String add(Event element) {
        boolean validation = validate(element);
        if (!validation) {
            return invalid();
        }
        if (size == array.length) {
            Event[] temp = new Event[size * 2];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
        array[size] = element;
        array[size].setId(++id);
        size++;
        return "Event has been successfully added.";
    }

    /**
     * Sets the value equals to the parameter element to the Event in the array with id equals to the parameter id.
     *
     * @cpu O(n), n = instance variable "size"
     * @ram O(1)
     *
     * @param id int argument
     * @param element Event object
     * @return a String with information.
     */
    public String set(int id, Event element) {
        boolean validation = validate(element);
        if (!validation) {
            return invalid();
        }
        int index = searchById(id);
        if (index < 0) {
            return "Event with id#" + id + " has not been found.";
        } else {
            array[index] = element;
            array[index].setId(id);
            return "Event with id#" + id + " has been successfully changed.";
        }
    }

    /**
     * Removes the element with the id equals to the parameter id.
     *
     * @cpu O(n), n = instance variable "size"
     * @ram O(1)
     *
     * @param id int argument
     * @return a String with information.
     */
    public String remove(int id) {
        int index = searchById(id);
        if (index < 0) {
            return "Event with id#" + id + " has not been found.";
        } else {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            size--;
            return "Event with id#" + id + " has been successfully removed.";
        }
    }

    /**
     * Returns all events from the array.
     *
     * @cpu O(n(log(n))m), n = instance variable "size", m = min of name length
     * @ram O(n), n = instance variable "size"
     *
     * @return all events from the array.
     */
    public Event[] getAll() {
        mergeSort();
        Event[] events = new Event[size];
        System.arraycopy(array, 0, events, 0, size);
        return events;
    }

    /**
     * Returns all events from the array with the year equals to the parameter year.
     *
     * @cpu O(n(log(n))m), n = instance variable "size", m = min of name length
     * @ram O(n), n = instance variable "size"
     *
     * @param year int argument
     * @return events with the asked year.
     */
    public Event[] getByYear(int year) {
        mergeSort();
        int[] indexes = searchIndexes(year, 0, size, "year");
        int from = indexes[0];
        int to = indexes[1];
        Event[] events = new Event[to - from];
        System.arraycopy(array, from, events, 0, events.length);
        return events;
    }

    /**
     * Returns all events from the array with the year equals to the parameter year
     *          and the month equals to the parameter month.
     *
     * @cpu O(n(log(n))m), n = instance variable "size", m = min of name length
     * @ram O(n), n = instance variable "size"
     *
     * @param month int argument
     * @param year int argument
     * @return events with the asked year and month.
     */
    public Event[] getByMonth(int month, int year) {
        mergeSort();
        int[] indexes = searchIndexes(year, 0, size, "year");
        int from = indexes[0];
        int to = indexes[1];
        indexes = searchIndexes(month, from, to, "month");
        from = indexes[0];
        to = indexes[1];
        Event[] events = new Event[to - from];
        System.arraycopy(array, from, events, 0, events.length);
        return events;
    }

    /**
     * Returns all events from the array with the asked date.
     *
     * @cpu O(n(log(n))m), n = instance variable "size", m = min of name length
     * @ram O(n), n = instance variable "size"
     *
     * @param day int argument
     * @param month int argument
     * @param year int argument
     * @return events with the asked date.
     */
    public Event[] getByDate(int day, int month, int year) {
        mergeSort();
        int[] indexes = searchIndexes(year, 0, size, "year");
        int from = indexes[0];
        int to = indexes[1];
        indexes = searchIndexes(month, from, to, "month");
        from = indexes[0];
        to = indexes[1];
        indexes = searchIndexes(day, from, to, "day");
        from = indexes[0];
        to = indexes[1];
        Event[] events = new Event[to - from];
        System.arraycopy(array, from, events, 0, events.length);
        return events;
    }

    private int[] searchIndexes(int value, int from, int to, String eventVariable) {
        int[] indexes = new int[2];
        if (eventVariable.equals("year")) {
            indexes[0] = binarySearch(from, to, value, "year");
            indexes[1] = binarySearch(indexes[0], to, value + 1, "year");
            return indexes;
        } else if (eventVariable.equals("month")) {
            indexes[0] = binarySearch(from, to, value, "month");
            indexes[1] = binarySearch(indexes[0], to, value + 1, "month");
            return indexes;
        } else {
            indexes[0] = binarySearch(from, to, value, "day");
            indexes[1] = binarySearch(indexes[0], to, value + 1, "day");
            return indexes;
        }
    }

    private int searchById(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private static int compare(Event event, Event that) {
        int compare = event.compareTo(that);
        if (compare == 0) {
            char[] thisChars = event.getName().toCharArray();
            char[] thatChars = that.getName().toCharArray();
            int length = Math.min(thisChars.length, thatChars.length);
            for (int i = 0; i < length; i++) {
                if (thisChars[i] < thatChars[i]) {
                    return -1;
                }
                if (thisChars[i] > thatChars[i]) {
                    return 1;
                }
            }
            if (thisChars.length < thatChars.length) {
                return -1;
            }
            if (thisChars.length > thatChars.length) {
                return 1;
            }
        }
        return compare;
    }

    private void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom) {
        int indexA = aFrom;
        int indexB = bFrom;
        int rTo = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom; i < rTo; i++) {
            if (indexA < aTo && (indexB >= bTo || compare(a[indexA], (b[indexB])) <= 0)) {
                r[i] = a[indexA];
                indexA++;
            } else {
                r[i] = b[indexB];
                indexB++;
            }
        }
    }

    private void mergeSort() {
        Event[] currentScr = new Event[this.size];
        System.arraycopy(array, 0, currentScr, 0, this.size);
        Event[] destination = new Event[this.size];
        int size = 1;
        while (size < this.size) {
            for (int i = 0; i < this.size; i += size * 2) {
                int fromTo = i + size;
                if (fromTo >= this.size) {
                    fromTo = this.size - 1;
                }
                int to = i + size * 2;
                if (to > this.size) {
                    to = this.size;
                }
                merge(currentScr, i, fromTo, currentScr, fromTo, to, destination, i);
            }
            Event[] tmp = currentScr;
            currentScr = destination;
            destination = tmp;
            size = size * 2;
        }
        System.arraycopy(currentScr, 0, array, 0, this.size);
    }

    private int binarySearch(int fromIndex, int toIndex, int key, String eventVariable) {
        int l = fromIndex;
        int r = toIndex - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int value = checkEventVariable(m, eventVariable);
            if (key < value) {
                r = m - 1;
            } else if (key > value) {
                l = m + 1;
            } else {
                if (m - 1 >= 0 && checkEventVariable(m - 1, eventVariable) == key) {
                    r = m - 1;
                } else {
                    return m;
                }
            }
        }
        return l;
    }

    private int checkEventVariable(int m, String eventVariable) {
        if (eventVariable.equals("year")) {
            return array[m].getYear();
        }
        if (eventVariable.equals("month")) {
            return array[m].getMonth();
        } else {
            return array[m].getDay();
        }
    }

    private boolean validate(Event event) {
        return event != null && event.getYear() > 0 && event.getMonth() > 0 && event.getMonth() < 13
                && event.getDay() > 0 && event.getDay() < 32 && event.getName().length() < 101;
    }

    private String invalid() {
        return "Invalid event." + "\n"
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
    }
}
