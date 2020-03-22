package academy.everyonecodes.advyml.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class NaturalNumber {
    private int naturalNumber;

    public int getNumber() {
        return naturalNumber;
    }

    void setNaturalNumber(int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }
}
