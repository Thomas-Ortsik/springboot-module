package academy.everyonecodes.punchcards.repo;

import academy.everyonecodes.punchcards.domain.PunchCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository extends MongoRepository<PunchCard, String> {
}
