package academy.everyonecodes.rides.repo;

import academy.everyonecodes.rides.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
