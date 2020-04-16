package academy.everyonecodes.todos.repo;

import academy.everyonecodes.todos.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
