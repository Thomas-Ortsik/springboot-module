package academy.everyonecodes.marathon.logic;

import academy.everyonecodes.marathon.domain.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarathonServiceTest {
@Autowired
MarathonService marathonService;

    @Test
    void add() {
        marathonService.add(new Runner("test", Duration.ofSeconds(30)));
        Set<Runner> expected = Set.of(new Runner("test", Duration.ofSeconds(30)));
        Set<Runner> result = marathonService.getRunners();
        assertEquals(expected, result);
    }

    @Test
    void findWinner() {
        marathonService.add(new Runner("test3", Duration.ofSeconds(50)));
        marathonService.add(new Runner("test2", Duration.ofSeconds(30)));
        marathonService.add(new Runner("test1", Duration.ofSeconds(10)));
        Runner expected = new Runner("test1", Duration.ofSeconds(10));
        Optional<Runner> oResult = marathonService.findWinner();
        assertTrue(oResult.isPresent());
        assertEquals(expected, oResult.get());
    }
}