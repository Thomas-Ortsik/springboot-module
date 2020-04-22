package academy.everyonecodes.socialnetwork.translator;

import academy.everyonecodes.socialnetwork.domain.Person;
import academy.everyonecodes.socialnetwork.domain.PersonDTO;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PersonTranslator {

    public PersonDTO toPersonDTO(Person person){
        List<String> friends = person.getFriends().stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        return new PersonDTO(person.getId(),
                person.getName(),
                friends);
    }

    public Person toPerson(PersonDTO personDTO){
        return new Person(personDTO.getName(), new ArrayList<>());
    }
}
