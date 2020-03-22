package academy.everyonecodes.cc.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CreditCards {
    private Set<Issuer> issuers;
    private Luhn luhn;

    public CreditCards(Set<Issuer> issuers, Luhn luhn) {
        this.issuers = issuers;
        this.luhn = luhn;
    }

    public String inspect(String ccNumber){
        if (!luhn.isValid(ccNumber)){
            return "Invalid";
        }
        Optional<Issuer> issuer = findIssuer(ccNumber);
        if (issuer.isEmpty()){
            return "Not Supported";
        }
        return issuer.get().getName();
    }

    private Optional<Issuer> findIssuer(String ccNumber){
        return issuers.stream()
                .filter(issuer -> issuer.issues(ccNumber))
                .findAny();
    }


}
