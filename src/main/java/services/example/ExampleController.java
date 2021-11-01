package services.example;
import org.springframework.web.bind.annotation.*;

/**
 * ExampleController
 */

@RestController
public class ExampleController {

    /**
     * Returns an example String.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return an example String.
     */
    @GetMapping("/")
    public String index() {
        return "I'm your first web-service";
    }

    /**
     * Returns an example String.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return an example String.
     */
    @GetMapping("/second")
    public String second() {
        return "I'm the second binding";
    }

    /**
     * Returns an example String.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return an example String.
     */
    @PostMapping("/second")
    public String secondPost() {
        return "I'm post mapping";
    }

    /**
     * Returns an example String.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return an example String.
     */
    @PutMapping("/second")
    public String secondPut() {
        return "I'm put mapping";
    }

    /**
     * Returns an example String.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return an example String.
     */
    @PatchMapping("/second")
    public String secondPatch() {
        return "I'm patch mapping";
    }

    /**
     * Returns an example String.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return an example String.
     */
    @DeleteMapping("/second")
    public String secondDelete() {
        return "I'm delete mapping";
    }
}
