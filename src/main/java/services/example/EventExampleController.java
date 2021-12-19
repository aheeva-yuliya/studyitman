package services.example;

import entities.Event;
import org.springframework.web.bind.annotation.*;

/**
 * EventExampleController.
 */
@RestController
public class EventExampleController {
    private Event event;

    /**
     * Gets JSON Event and saves it.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param body JSON Event
     */
    @PostMapping("/api/event")
    public void saveEvent(@RequestBody Event body) {
        event = body;
    }

    /**
     * Returns the last remembered Event in JSON format.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return the last remembered Event.
     */
    @GetMapping("/api/event")
    public Event getEvent() {
        return event;
    }
}
