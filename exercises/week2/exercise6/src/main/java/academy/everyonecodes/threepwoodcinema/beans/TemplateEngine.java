package academy.everyonecodes.threepwoodcinema.beans;

import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {
    private final TemplateMessageFinder templateMessageFinder;

    public TemplateEngine(TemplateMessageFinder templateMessageFinder) {
        this.templateMessageFinder = templateMessageFinder;
    }

    public String customiseMessage(String name){
        String promoTemplate = templateMessageFinder.find(name);
        return String.format(promoTemplate, name);
    }
}
