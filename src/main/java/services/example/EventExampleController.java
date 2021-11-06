package services.example;

import entities.Event;
import org.springframework.web.bind.annotation.*;


@RestController
public class EventExampleController {
    Event event;

    @PostMapping("/api/event")
    public void saveEvent(@RequestBody Event body) {
        event = body;
    }

    @GetMapping("/api/event")
    public Event getEvent() {
        return event;
    }
}
