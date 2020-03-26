package academy.everyonecodes.devskills.logic;

import academy.everyonecodes.devskills.domain.Developer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeveloperServiceTest {
@Autowired
DeveloperService developerService;

    static List<Developer> expected = List.of(
            new Developer("Seth", Set.of("Javascript", "CSS", "HTML")),
            new Developer("Sarah", Set.of("Java", "Spring-Boot")),
            new Developer("Sonia", Set.of("Python", "HTML", "CSS")),
            new Developer("Tom", Set.of("Kotlin", "Python", "Javascript"))
    );

    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(List.of(), "C++"),
                Arguments.of(List.of(expected.get(0), expected.get(3)), "Javascript"),
                Arguments.of(List.of(expected.get(1)), "Java Spring-Boot"),
                Arguments.of(List.of(), "Java Spring-Boot CSS")
        );
    }

    @Test
    void findAll() {
        List<Developer> result = developerService.findAll();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Developer> expected, String input) {
        List<Developer> result = developerService.findBy(input);
        assertEquals(expected, result);
    }
}