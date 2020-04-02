package academy.everyonecodes.complexformula.client;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FormulaClientTest {
    @Autowired
    FormulaClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${url.interactions}")
    String url;

    @Test
    void getFormulaResult() {
        Integer input = 1;
        client.getFormulaResult(input);
        Mockito.verify(restTemplate).postForObject(url, input, Integer.class);
    }
}