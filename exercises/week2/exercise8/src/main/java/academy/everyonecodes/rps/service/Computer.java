package academy.everyonecodes.rps.service;

import academy.everyonecodes.rps.data.Move;
import academy.everyonecodes.rps.interfaces.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class Computer implements Player {
    private final List<Move> moves;
    private final Random random = new Random();
    public Computer(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public Move play() {
        Move move = moves.get(random.nextInt(moves.size()));
        System.out.println("Computer chose: " + move.getName());
        return move;
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
