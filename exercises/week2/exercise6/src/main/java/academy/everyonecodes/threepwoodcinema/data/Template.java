package academy.everyonecodes.threepwoodcinema.data;

import org.springframework.stereotype.Service;

@Service

public class Template {
    private String name;
    private String keyword;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }
}
