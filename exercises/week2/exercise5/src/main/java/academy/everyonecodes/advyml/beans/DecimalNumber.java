package academy.everyonecodes.advyml.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class DecimalNumber {
    private double number;

    public double getNumber() {
        return number;
    }

    void setDecimalNumber(double decimalNumber) {
        this.number = decimalNumber;
    }
}
