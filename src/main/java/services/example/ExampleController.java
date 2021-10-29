package services.example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("second/")
    public String secondIndex() {
        return "I'm the second binding";
    }
}
