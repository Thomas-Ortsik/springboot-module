package academy.everyonecodes.musicstation.logic;

import academy.everyonecodes.musicstation.domain.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MusicStationTest {
@Autowired
MusicStation musicStation;

//and my tests aren't working either, because for some reason intelliJ can't access my test property file :D
// This is such a mess

static Stream<Arguments> parameters(){
    return Stream.of(
            Arguments.of(List.of(new Song("test1", "one")), "one"),
            Arguments.of(List.of(), ""),
            Arguments.of(List.of(
                    new Song("test2", "two"),
                    new Song("test3", "two")),
                    "two"));
}

    @Test
    void findAll() {
    List<Song> expected = List.of(
            new Song("test1", "one"),
            new Song("test2", "two"),
            new Song("test3", "two"));
    List<Song> result = musicStation.findAll();
    System.out.println(result.get(0).getName());
    assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Song> expected, String input) {
    List<Song> result = musicStation.findBy(input);
    assertEquals(expected, result);
    }
}