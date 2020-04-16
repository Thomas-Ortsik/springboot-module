package academy.everyonecodes.todos.logic;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.repo.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {
    private final ToDoRepository repository;

    public ToDoManager(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> getAll() {
        return repository.findAll();
    }

    public Optional<ToDo> getByID(String id) {
        return repository.findById(id);
    }

    public ToDo newToDo(ToDo toDo) {
        repository.save(toDo);
        return toDo;
    }

    public Optional<ToDo> markAsDone(String id) {
        Optional<ToDo> oToDo = repository.findById(id);
        if (oToDo.isPresent()) {
            ToDo toDo = oToDo.get();
            toDo.setDone(true);
            repository.save(toDo);
            oToDo = Optional.of(toDo);
        }
        return oToDo;
    }

    public void deleteToDo(String id) {
        repository.deleteById(id);
    }

}
