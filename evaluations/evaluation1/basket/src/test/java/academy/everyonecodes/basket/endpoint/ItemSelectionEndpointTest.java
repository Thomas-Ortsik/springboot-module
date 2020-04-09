package academy.everyonecodes.basket.endpoint;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.Basket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemSelectionEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    Basket basket;

    ItemSelection input = new ItemSelection("testMail", "testItem", 1.5);
    String url = "/itemselections";
    @Test
    void post() {
        restTemplate.postForObject(url, input, ItemSelection.class);
        Mockito.verify(basket).addToBasket(input);
    }
}