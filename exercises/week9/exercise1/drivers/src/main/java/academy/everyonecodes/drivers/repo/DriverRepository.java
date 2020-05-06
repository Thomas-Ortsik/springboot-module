package academy.everyonecodes.drivers.repo;

import academy.everyonecodes.drivers.domain.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver, String> {
    Optional<Driver> findByUsername(String username);
}
