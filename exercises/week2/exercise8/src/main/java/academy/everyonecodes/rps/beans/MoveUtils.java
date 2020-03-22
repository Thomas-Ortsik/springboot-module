package academy.everyonecodes.rps.beans;

import academy.everyonecodes.rps.data.Move;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveUtils {
    private List<Move> moves;

    public MoveUtils(List<Move> moves) {
        this.moves = moves;
    }

    public String getNames() {
        return moves.stream()
                .map(Move::getName)
                .reduce((move, move2) -> move + ", " + move2).orElse("no known moves");
    }

    public Optional<Move> getOne(String moveName) {
        return moves.stream()
                .filter(move -> move.getName().equals(moveName))
                .findAny();
    }
}
