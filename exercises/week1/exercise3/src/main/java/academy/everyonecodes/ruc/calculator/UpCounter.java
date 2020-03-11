package academy.everyonecodes.ruc.calculator;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpCounter {
    private final UpDownIndicator upDownIndicator;

    public UpCounter(UpDownIndicator upDownIndicator) {
        this.upDownIndicator = upDownIndicator;
    }

    public long count(List<Double> numbers){
        return numbers.stream()
                .filter(this::isUp)
                .count();
    }

    private boolean isUp(double number){
        return upDownIndicator.indicate(number).equals("UP");
    }
}
