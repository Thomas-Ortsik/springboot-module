package academy.everyonecodes.mysterycalc.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysteriousNumberCalculator {
    private final List<MysteriousAddition> mysteriousAdditions;
    private final MysteriousNumberFormatter numberFormatter;

    public MysteriousNumberCalculator(List<MysteriousAddition> mysteriousAdditions, MysteriousNumberFormatter numberFormatter) {
        this.mysteriousAdditions = mysteriousAdditions;
        this.numberFormatter = numberFormatter;
    }

    public String calculate(int number){
        //It's number+1+2, not (number+1) + (number+2), right?
        return mysteriousAdditions.stream()
                .map(mysteriousAddition -> mysteriousAddition.apply(number))
                .reduce((mysteriousAdditionOne, mysteriousAdditionTwo) -> mysteriousAdditionOne+mysteriousAdditionTwo-number)
                .map(numberFormatter::format)
                .get();
    }
}
