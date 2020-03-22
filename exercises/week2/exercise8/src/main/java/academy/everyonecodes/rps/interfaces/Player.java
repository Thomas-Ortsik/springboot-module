package academy.everyonecodes.rps.interfaces;

import academy.everyonecodes.rps.data.Move;

public interface Player {
    public Move play();
    public boolean wantsToPlayAgain();
}
