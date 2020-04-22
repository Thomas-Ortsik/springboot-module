package academy.everyonecodes.couchpotato.endpoint;

import academy.everyonecodes.couchpotato.domain.Film;
import academy.everyonecodes.couchpotato.repo.FilmRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {
    private final FilmRepository repo;

    public FilmEndpoint(FilmRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    List<Film> get(){
        return repo.findAll();
    }

    @PostMapping
    Film post(@Valid @RequestBody Film film){
        return repo.save(film);
    }



}
