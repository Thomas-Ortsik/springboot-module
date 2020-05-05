package academy.everyonecodes.scheduling.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@EnableScheduling
public class Scheduler {
    @Value("${fixed-delay.message}")
    private String delayMessage;
    @Value("${fixed-rate.message}")
    private String rateMessage;
    @Value("${cron-message.message}")
    private String cronMessage;

    @Scheduled(fixedDelayString = "${fixed-delay.timer}")
    public void fixedDelay(){
        System.out.println(delayMessage);
    }

    @Scheduled(fixedRateString = "${fixed-rate.timer}")
    public void fixedRate(){
        System.out.println(rateMessage);
    }

    @Scheduled(cron = "${cron-message.interval}")
    public void cronMessage(){
        System.out.println(cronMessage);
    }
}
