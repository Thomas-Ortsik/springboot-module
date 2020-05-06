package academy.everyonecodes.rides.repo;

import academy.everyonecodes.rides.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
