package academy.everyonecodes.languagebarriers.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String message(String message){
        return message;
    }
}
