package academy.everyonecodes.todos.endpoint;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.logic.ToDoManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoEndpoint {
    private final ToDoManager manager;

    public ToDoEndpoint(ToDoManager manager) {
        this.manager = manager;
    }

    @GetMapping
    List<ToDo> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    ToDo getByID(@PathVariable String id) {
        return manager.getByID(id).orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return manager.newToDo(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo putDone(@PathVariable String id) {
        return manager.markAsDone(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        manager.deleteToDo(id);
    }
}
