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

    /**
     * Extracts data and substitutes into a method.
     *
     * @cpu O()
     * @ram O()
     *
     * @param pathVariable String argument
     * @param secondVariable int argument
     * @param required String argument
     * @param optional String argument
     * @param defaultValue int argument
     * @param body String argument
     * @return response
     */
    @PostMapping("/extract/{pathVariable}/{second}")
    public String extract(@PathVariable String pathVariable,
                          @PathVariable(name = "second") int secondVariable,
                          @RequestParam String required,
                          @RequestParam(required = false) String optional,
                          @RequestParam(name = "default", defaultValue = "-1") int defaultValue,
                          @RequestBody String body) {
        return "patchVariable = " + pathVariable + "\n"
                + "second = " + secondVariable + "\n"
                + "required = " + required + "\n"
                + "optional = " + optional + "\n"
                + "default = " + defaultValue + "\n"
                + "body = " + body + "\n";
    }
}
