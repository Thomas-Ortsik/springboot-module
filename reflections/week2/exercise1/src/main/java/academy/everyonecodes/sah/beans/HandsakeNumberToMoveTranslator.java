package academy.everyonecodes.sah.beans;

import academy.everyonecodes.sah.domain.Handshake;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@ConfigurationProperties("secretagent")
public class HandsakeNumberToMoveTranslator {
    private Set<Handshake> handshakes;

    void setHandshakes(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public Optional<String> translate(int number){
        return handshakes.stream()
                .filter(handshake -> handshake.getNumber()==number)
                .map(Handshake::getMove)
                .findAny();
    }
}
