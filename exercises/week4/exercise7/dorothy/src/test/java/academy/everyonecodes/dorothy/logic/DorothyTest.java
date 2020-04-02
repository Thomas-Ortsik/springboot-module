package academy.everyonecodes.dorothy.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DorothyTest {
    @Autowired
    Dorothy dorothy;
    @MockBean
    RestTemplate restTemplate;
    @Value("${url.wizard}")
    String url;

    @Test
    void findHome() {

        Mockito.when(restTemplate.getForObject(url, String.class)).thenReturn("/testURL");
        Mockito.when(restTemplate.getForObject("/testURL", String.class)).thenReturn("TestHome");
        String expected = "My home is TestHome";
        String result = dorothy.findHome();
        Mockito.verify(restTemplate).getForObject("/testURL", String.class);
        Mockito.verify(restTemplate).getForObject(url, String.class);
        assertEquals(expected, result);
    }
}