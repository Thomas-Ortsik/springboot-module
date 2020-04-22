package academy.everyonecodes.socialnetwork.endpoint;

import academy.everyonecodes.socialnetwork.client.PersonsClient;
import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsEndpoint {
    private final PersonsClient client;

    public PersonsEndpoint(PersonsClient client) {
        this.client = client;
    }

    @GetMapping
    List<PersonDTO> getAll(){
        return client.getAllPersons();
    }

    @PostMapping
    PersonDTO post(@RequestBody PersonDTO personDTO){
        return client.savePerson(personDTO);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void putFriend(@PathVariable Long id1, @PathVariable Long id2){
        client.addFriends(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void putUnfriend(@PathVariable Long id1, @PathVariable Long id2){
        client.removeFriends(id1, id2);
    }
}
