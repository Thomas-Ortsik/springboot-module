package academy.everyonecodes.threepwoodcinema.beans;

import academy.everyonecodes.threepwoodcinema.data.Template;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("cinema.specialoffer")
public class TemplateMessageFinder {
    private List<Template> templates;
    private String defaultMessage;

    TemplateMessageFinder() {
    }

    public TemplateMessageFinder(List<Template> templates) {
        this.templates = templates;
    }

    public String find(String name) {
        return templates.stream()
                .filter(template -> name.contains(template.getKeyword()))
                .map(Template::getMessage)
                .findAny().orElse(defaultMessage);
    }

    void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
