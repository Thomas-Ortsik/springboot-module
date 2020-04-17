package academy.everyonecodes.drhousetreatments.repo;

import academy.everyonecodes.drhousetreatments.domain.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TreatmentRepository extends MongoRepository<Treatment, String> {
    List<Treatment> findByUuid(String uuid);
}
