package academy.everyonecodes.phonebook.endpoint;

import academy.everyonecodes.phonebook.ContactClient;
import academy.everyonecodes.phonebook.domain.Contact;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/contacts")
public class ContactsEndpoints {
    private final ContactClient client;

    public ContactsEndpoints(ContactClient client) {
        this.client = client;
    }

    @PostMapping
    Contact post(@Valid @RequestBody Contact contact) {
        return client.post(contact);
    }

    @GetMapping
    List<Contact> getAll() {
        return client.getAll();
    }

    @GetMapping("postalcodes/{postalCode}")
    List<Contact> getContactFromPostalcode(@PathVariable String postalCode) {
        return client.getByPostalCode(postalCode);
    }
}
