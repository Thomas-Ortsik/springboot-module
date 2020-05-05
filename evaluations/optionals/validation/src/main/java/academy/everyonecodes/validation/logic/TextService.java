package academy.everyonecodes.validation.logic;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TextService {
    @Length(min = 3)
    public String verifyLength(String string){
        return string;
    }
}
