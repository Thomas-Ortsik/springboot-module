package academy.everyonecodes.ruc.calculator;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {
    private final Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double number) {
        if (number % 0.5 == 0) {
            return "SAME";
        }
        double differenceDown = number - rounder.roundDown(number);
        double differenceUp = rounder.roundUp(number) - number;
        if (differenceUp > differenceDown) {
            return "DOWN";
        }
        return "UP";
    }
}
