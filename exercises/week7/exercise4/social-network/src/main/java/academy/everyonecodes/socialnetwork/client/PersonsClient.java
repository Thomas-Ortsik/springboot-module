package academy.everyonecodes.socialnetwork.client;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import academy.everyonecodes.socialnetwork.logic.FriendshipHandler;
import academy.everyonecodes.socialnetwork.repo.PersonRepository;
import academy.everyonecodes.socialnetwork.translator.PersonTranslator;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class PersonsClient {
    private final PersonTranslator translator;
    private final FriendshipHandler friendshipHandler;
    private final PersonRepository repository;

    public PersonsClient(PersonTranslator translator, FriendshipHandler friendshipHandler, PersonRepository repository) {
        this.translator = translator;
        this.friendshipHandler = friendshipHandler;
        this.repository = repository;
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        Person person = translator.toPerson(personDTO);
        repository.save(person);
        return translator.toPersonDTO(person);
    }

    public List<PersonDTO> getAllPersons() {
        return repository.findAll().stream()
                .map(translator::toPersonDTO)
                .collect(Collectors.toList());
    }

    public void addFriends(Long id1, Long id2) {
        Optional<Person> oPersonA = repository.findById(id1);
        Optional<Person> oPersonB = repository.findById(id2);
        if (oPersonA.isPresent() && oPersonB.isPresent()) {
            Person personA = oPersonA.get();
            Person personB = oPersonB.get();
            friendshipHandler.linkFriends(personA, personB);
            //repository.saveAll(List.of(personA, personB));
            //why is this shit not working when i already have a friend?!
            repository.save(personA);
            repository.save(personB);
        }
    }

    public void removeFriends(Long id1, Long id2) {
        Optional<Person> oPersonA = repository.findById(id1);
        Optional<Person> oPersonB = repository.findById(id2);
        if (oPersonA.isPresent() && oPersonB.isPresent()) {
            Person personA = oPersonA.get();
            Person personB = oPersonB.get();
            friendshipHandler.unlinkFriends(personA, personB);
            repository.saveAll(List.of(personA, personB));
        }
    }
}
