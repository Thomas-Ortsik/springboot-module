package academy.everyonecodes.cc.service;

import java.util.Set;

public class Issuer {
    private String name;
    private Set<String> startsWith;
    private Set<Integer> lengths;

    Issuer() {
    }

    public Issuer(String name, Set<String> startsWith, Set<Integer> lengths) {
        this.name = name;
        this.startsWith = startsWith;
        this.lengths = lengths;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    void setLengths(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    public boolean issues(String ccNumber) {
        return startsWith(ccNumber) && correctLength(ccNumber);
    }

    private boolean correctLength(String ccNumber) {
        return lengths.stream()
                .anyMatch(length -> ccNumber.length() == length);
    }

    private boolean startsWith(String ccNumber) {
        return startsWith.stream()
                .anyMatch(ccNumber::startsWith);
    }
}
