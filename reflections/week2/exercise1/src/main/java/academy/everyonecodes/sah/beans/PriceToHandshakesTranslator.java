package academy.everyonecodes.sah.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceToHandshakesTranslator {
    private int minPrice;
    private int maxPrice;
    private HandsakeNumberToMoveTranslator translator;


    public PriceToHandshakesTranslator(@Value("${secretagent.minprice}") int minPrice,
                                       @Value("${secretagent.maxprice}")int maxPrice, HandsakeNumberToMoveTranslator translator) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.translator = translator;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<String> translate(int number) {
        String numberString = String.valueOf(number);
        List<String> numbers = List.of(numberString.split(""));
        return numbers.stream()
                .map(num -> translator.translate(Integer.valueOf(num)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
