package academy.everyonecodes.languagebarriers.service;

import org.springframework.stereotype.Service;

@Service
public class InteractionsService {
    private int interactionCount;

    public int getInteractionCount() {
        return interactionCount;
    }

    public void increaseCount(){
        interactionCount++;
    }
}
