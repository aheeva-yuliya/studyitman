package services.calendar;

import entities.Event;
import org.springframework.web.bind.annotation.*;

/**
 * CalendarController
 */
@RestController
public class CalendarController {
    private final DynamicEventList dynamicEventList = new DynamicEventList();
    private Event event;

    /**
     * Checks the data object and adds it to the array of DynamicEventList or returns an error message.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param body an Event object
     * @return a String with information.
     */
    @PostMapping("/api/add")
    public String addEvent(@RequestBody Event body) {
        event = body;
        return dynamicEventList.add(event);
    }

    /**
     * Checks and sets the event by id that gets from a user or returns an error message.
     *
     * @cpu O(n), n = instance variable "size"
     * @ram O(1)
     *
     * @param id int argument
     * @param body Event object
     * @return a String with information.
     */
    @PatchMapping("/api/set/{id}")
    public String setEvent(@PathVariable (name = "id") int id,
                           @RequestBody Event body) {
        event = body;
        return dynamicEventList.set(id, event);
    }

    /**
     * Removes the event by id that gets from a user or returns an error message.
     *
     * @cpu O(n), n = instance variable "size"
     * @ram O(1)
     *
     * @param id int argument
     * @return a String with information.
     */
    @DeleteMapping("/api/delete/{id}")
    public String deleteEvent(@PathVariable (name = "id") int id) {
        return dynamicEventList.remove(id);
    }

    /**
     * Returns all events from the array of an object of DynamicEventList.
     *
     * @cpu O(n(log(n))), n = instance variable "size" of an object of DynamicEventList.
     * @ram O(n), n = instance variable "size" of an object of DynamicEventList.
     *
     * @return all events from the array of an object of DynamicEventList.
     */
    @GetMapping("/api/get/all")
    public Event[] getEvents() {
        return dynamicEventList.getAll();
    }

    /**
     * Returns all events from the array with the year equals to the parameter year.
     *
     * @cpu O(n(log(n))), n = instance variable "size" of an object of DynamicEventList.
     * @ram O(n), n = instance variable "size" of an object of DynamicEventList.
     *
     * @param year int argument
     * @return events with the asked year.
     */
    @GetMapping("/api/get/year/{year}")
    public Event[] getEventsByYear(@PathVariable (name = "year") int year) {
        return dynamicEventList.getByYear(year);
    }

    /**
     * Returns all events from the array with the year equals to the parameter year
     *          and the month equals to the parameter month.
     *
     * @cpu O(n(log(n))), n = instance variable "size" of an object of DynamicEventList.
     * @ram O(n), n = instance variable "size" of an object of DynamicEventList.
     *
     * @param month int argument
     * @param year int argument
     * @return events with the asked year and month.
     */
    @GetMapping("/api/get/month/{month}/year/{year}")
    public Event[] getEventsByMonth(@PathVariable (name = "month") int month,
                                    @PathVariable (name = "year") int year) {
        return dynamicEventList.getByMonth(month, year);
    }

    /**
     * Returns all events from the array with the asked date.
     *
     * @cpu O(n(log(n))), n = instance variable "size" of an object of DynamicEventList.
     * @ram O(n), n = instance variable "size" of an object of DynamicEventList.
     *
     * @param day int argument
     * @param month int argument
     * @param year int argument
     * @return events with the asked date.
     */
    @GetMapping("/api/get/day/{day}/month/{month}/year/{year}")
    public Event[] getEventsByDate(@PathVariable (name = "day") int day,
                                   @PathVariable (name = "month") int month,
                                   @PathVariable (name = "year") int year) {
        return dynamicEventList.getByDate(day, month, year);
    }
}
