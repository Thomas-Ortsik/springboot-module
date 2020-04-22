package academy.everyonecodes.phonebook.repo;

import academy.everyonecodes.phonebook.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPostalCode(String postalCode);
}
