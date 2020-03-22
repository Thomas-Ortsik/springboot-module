package academy.everyonecodes.rps.beans;

import academy.everyonecodes.rps.data.Move;
import academy.everyonecodes.rps.interfaces.Player;
import org.springframework.stereotype.Service;

@Service
public class Game {
    private Player player1;
    private Player player2;
    private Judge judge;

    public Game(Player player1, Player player2, Judge judge) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
    }

    public void play(){
        while(true){
            Move player1Move = player1.play();
            Move player2Move = player2.play();
            System.out.println(judge.judge(player1Move, player2Move));
            if (endGame()){ break;}
        }
    }

    private boolean endGame(){
        boolean newGame = player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
        return !newGame;
    }
}
