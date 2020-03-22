package academy.everyonecodes.advyml.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class Message {
    private String message;

    void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
