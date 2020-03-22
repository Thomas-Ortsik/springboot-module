package academy.everyonecodes.basicyml.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumber {
    private final int number;

    public NaturalNumber(@Value("${basic.naturalnumber}") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
