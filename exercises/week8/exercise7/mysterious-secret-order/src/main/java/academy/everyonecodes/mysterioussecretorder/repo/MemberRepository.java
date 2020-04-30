package academy.everyonecodes.mysterioussecretorder.repo;

import academy.everyonecodes.mysterioussecretorder.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {
    boolean existsByUsername(String username);
    List<Member> findByAuthorities(String authorities);
    Optional<Member> findByUsername(String username);
}
