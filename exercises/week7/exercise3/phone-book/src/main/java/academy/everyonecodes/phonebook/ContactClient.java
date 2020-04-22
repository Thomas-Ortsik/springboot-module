package academy.everyonecodes.phonebook;

import academy.everyonecodes.phonebook.domain.Address;
import academy.everyonecodes.phonebook.domain.Contact;
import academy.everyonecodes.phonebook.repo.AddressRepository;
import academy.everyonecodes.phonebook.repo.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ContactClient {
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public ContactClient(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    public Contact post(Contact contact) {
        Address address = contact.getAddress();
        addressRepository.save(address);
        return contactRepository.save(contact);
    }

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    public List<Contact> getByPostalCode(String postalCode) {
        List<Address> addresses = addressRepository.findByPostalCode(postalCode);
        return addresses.stream()
                .map(contactRepository::findByAddress)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
