package academy.everyonecodes.basictypes.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypesEndoint {

    @GetMapping("/text")
    String getTypeText(){
        return "Types";
    }

    @GetMapping("/number")
    int getTypeNumber(){
        return 25920;
    }

    @GetMapping("/choice")
    boolean getTypeChoice(){
        return false;
    }
}
