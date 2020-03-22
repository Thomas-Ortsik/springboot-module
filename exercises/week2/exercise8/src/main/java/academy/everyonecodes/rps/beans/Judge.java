package academy.everyonecodes.rps.beans;

import academy.everyonecodes.rps.data.Move;
import org.springframework.stereotype.Service;

@Service
public class Judge {
    public String judge(Move player1, Move player2){
    if (player1.getDefeats().equals(player2.getName())){
        return "Player 1 won";
    }
    if (player2.getDefeats().equals(player1.getName())){
        return "Player 2 won";
    }
    return "It's a draw";
    }
}
