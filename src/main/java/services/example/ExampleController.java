package services.example;
import org.springframework.web.bind.annotation.*;
import utils.StringBuilder;

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
     * @cpu O(n + m + k + l) n = pathVariable. length, m = required. length, k = optional. length, l = body. length
     * @ram O(n + m + k + l) n = pathVariable. length, m = required. length, k = optional. length, l = body. length
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
        return "pathVariable = " + pathVariable + "\n"
                + "second = " + secondVariable + "\n"
                + "required = " + required + "\n"
                + "optional = " + optional + "\n"
                + "default = " + defaultValue + "\n"
                + "body = " + body + "\n";
    }

    /**
     * Returns numbers from the parameter FROM to the parameter TO.
     *
     * @cpu O(n) n = to - from
     * @ram O(n) n = to - from
     *
     * @param from int argument
     * @param to int argument
     * @return a String with the all numbers from a new line.
     */
    @GetMapping("/api/range")
    public String getNumbersFromQuery(@RequestParam int from,
                                      @RequestParam int to) {
        StringBuilder stringBuilder = createBody(from, to);
        return stringBuilder.toString();
    }

    /**
     * Returns numbers from the parameter FROM to the parameter TO.
     *
     * @cpu O(n) n = to - from
     * @ram O(n) n = to - from
     *
     * @param from int argument
     * @param to int argument
     * @return a String with the all numbers from a new line.
     */
    @GetMapping("/api/range/{from}/{to}")
    public String getNumbersFromPath(@PathVariable(name = "from") int from,
                                     @PathVariable(name = "to") int to) {
        StringBuilder stringBuilder = createBody(from, to);
        return stringBuilder.toString();
    }

    private StringBuilder createBody(final int from, final int to) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = from; i < to - 1; i++) {
            stringBuilder.append(i);
            stringBuilder.append("\n");
        }
        stringBuilder.append(to - 1);
        return stringBuilder;
    }
}
