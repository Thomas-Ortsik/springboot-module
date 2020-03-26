package academy.everyonecodes.interactions.endpoints;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {

    private List<String> colors = new ArrayList<>();

    @GetMapping
    List<String> getAll() {
        return colors;
    }

    @GetMapping("/{name}")
    String getOne(@PathVariable String name) {
        if (colors.contains(name)) {
            return name;
        }
        return "The color is not available in the app";
    }

    @PostMapping
    String post(@RequestBody String color) {
        colors.add(color);
        return color;
    }

    @PutMapping("/{target}")
    String put(@PathVariable String target, @RequestBody String replacement) {
        colors.remove(target);
        colors.add(replacement);
        return replacement;
    }

    @DeleteMapping
    void deleteAll() {
        colors.clear();
    }

    @DeleteMapping("/{name}")
    void deleteOne(@PathVariable String name) {
        colors.remove(name);
    }
}
