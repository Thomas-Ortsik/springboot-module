package academy.everyonecodes.phonebook.repo;

import academy.everyonecodes.phonebook.domain.Address;
import academy.everyonecodes.phonebook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByAddress(Address address);
}
