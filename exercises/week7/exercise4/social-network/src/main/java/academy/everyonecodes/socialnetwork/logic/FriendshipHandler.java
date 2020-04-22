package academy.everyonecodes.socialnetwork.logic;

import academy.everyonecodes.socialnetwork.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class FriendshipHandler {

    public void linkFriends(Person personA, Person personB) {
        personA.getFriends().add(personB);
        personB.getFriends().add(personA);
    }

    public void unlinkFriends(Person personA, Person personB) {
        personA.getFriends().remove(personB);
        personB.getFriends().remove(personA);
    }
}
