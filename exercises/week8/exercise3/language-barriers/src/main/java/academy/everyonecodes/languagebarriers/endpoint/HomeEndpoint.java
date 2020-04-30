package academy.everyonecodes.languagebarriers.endpoint;

import academy.everyonecodes.languagebarriers.service.HomeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeEndpoint {
    private final HomeService homeService;

    public HomeEndpoint(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    String get(@Value("${home.message}") String message){
        return homeService.message(message);
    }
}
