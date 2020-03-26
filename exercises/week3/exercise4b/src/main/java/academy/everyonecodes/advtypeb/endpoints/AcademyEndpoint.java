package academy.everyonecodes.advtypeb.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyEndpoint {
    private final List<String> academies;

    public AcademyEndpoint(List<String> academies) {
        this.academies = academies;
    }

    @GetMapping
    List<String> getAcademies(){
        return academies;
    }
}
