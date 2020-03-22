package academy.everyonecodes.rps.service;

import academy.everyonecodes.rps.beans.MoveUtils;
import academy.everyonecodes.rps.data.Move;
import academy.everyonecodes.rps.interfaces.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Human implements Player {
    private Scanner scanner= new Scanner(System.in);;
    private MoveUtils moveUtils;

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }

    @Override
    public Move play() {
        Optional<Move> oAppliedMove = Optional.empty();
        String availableMoves = moveUtils.getNames();
        while (oAppliedMove.isEmpty()) {
            System.out.println("Make your move. Available moves: " + availableMoves);
            String chosenMove = scanner.nextLine();
            oAppliedMove = moveUtils.getOne(chosenMove);
            if (oAppliedMove.isEmpty()) {
                System.out.println("Invalid move.");
            }
        }
        return oAppliedMove.get();

    }

    @Override
    public boolean wantsToPlayAgain() {
        List<String> trueOptions = List.of("yes", "y", "Y", "Yes", "true");
        System.out.println("Do you want to play again? (y/n)");
        String wantsToPlay = scanner.nextLine();
        return trueOptions.contains(wantsToPlay);
    }

}
