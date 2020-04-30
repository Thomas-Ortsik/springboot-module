package academy.everyonecodes.languagebarriers.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LanguagesService {
    private final InteractionsService interactions;

    public LanguagesService(InteractionsService interactions) {
        this.interactions = interactions;
    }

    public String availableLanguages(String available){
        interactions.increaseCount();
        return available;
    }

    public String welcomeGerman(String german){
        interactions.increaseCount();
        return german;
    }

    public String welcomeEnglish(String english){
        interactions.increaseCount();
        return english;
    }
}
