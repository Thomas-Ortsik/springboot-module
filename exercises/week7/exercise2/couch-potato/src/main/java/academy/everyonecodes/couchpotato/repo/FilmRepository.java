package academy.everyonecodes.couchpotato.repo;

import academy.everyonecodes.couchpotato.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
