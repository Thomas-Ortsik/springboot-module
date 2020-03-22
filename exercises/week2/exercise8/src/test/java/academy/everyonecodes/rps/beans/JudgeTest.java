package academy.everyonecodes.rps.beans;

import academy.everyonecodes.rps.data.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JudgeTest {
    Judge judge = new Judge();

    static Stream<Arguments> moveMaker() {
        Move rock = new Move("rock", "scissors");
        Move scissors = new Move("scissors", "paper");
        Move paper = new Move("paper", "rock");
        return Stream.of(
                Arguments.of("Player 1 won", rock, scissors),
                Arguments.of("Player 2 won", paper, scissors),
                Arguments.of("It's a draw", rock, rock));
    }

    @ParameterizedTest
    @MethodSource("moveMaker")
    void judge(String expected, Move player1, Move player2) {
        String result = judge.judge(player1,player2);
        Assertions.assertEquals(expected, result);
    }
}