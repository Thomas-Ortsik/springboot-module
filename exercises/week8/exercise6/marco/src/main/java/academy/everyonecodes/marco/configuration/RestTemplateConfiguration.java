package academy.everyonecodes.marco.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    private final Credentials credentials;

    public RestTemplateConfiguration(Credentials credentials) {
        this.credentials = credentials;
    }

    @Bean
    RestTemplate restTemplate() {
        System.out.println(credentials.getUsername() + " " + credentials.getPassword());
        return new RestTemplateBuilder()
                .basicAuthentication(credentials.getUsername(), credentials.getPassword())
                .build();
    }
}
