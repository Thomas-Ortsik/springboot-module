package academy.everyonecodes.steampurchases.repo;

import academy.everyonecodes.steampurchases.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
