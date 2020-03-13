package academy.everyonecodes.mysterycalc.service;

import org.springframework.stereotype.Service;

@Service
public class MysteriousNumberFormatter {

    public String format(int number){
        return "The mysterious number is " + String.valueOf(number);
    }
}
