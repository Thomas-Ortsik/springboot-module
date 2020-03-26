package academy.everyonecodes.devskills.logic;

import academy.everyonecodes.devskills.domain.Developer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {
    private List<Developer> developers;

    DeveloperService() {
    }

    public DeveloperService(List<Developer> developers) {
        this.developers = developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> findAll() {
        return developers;
    }

    public List<Developer> findBy(String skillsAsString) {
        List<String> skills = List.of(skillsAsString.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(skills))
                //.filter(developer -> developer.getSkills().stream().anyMatch(skills::contains))
                .collect(Collectors.toList());
    }
}
