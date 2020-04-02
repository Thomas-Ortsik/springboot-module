package academy.everyonecodes.marathonintegration.converter;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@ConfigurationPropertiesBinding
public class DurationConverter implements Converter<String, Duration> {
    @Override
    public Duration convert(String seconds) {
        return Duration.ofSeconds(Long.valueOf(seconds));
    }
}
