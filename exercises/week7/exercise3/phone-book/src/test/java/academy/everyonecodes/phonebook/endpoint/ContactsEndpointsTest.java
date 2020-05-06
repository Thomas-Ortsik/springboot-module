package academy.everyonecodes.phonebook.endpoint;

import academy.everyonecodes.phonebook.ContactClient;
import academy.everyonecodes.phonebook.domain.Contact;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactsEndpointsTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    ContactClient client;
    String url = "/contacts";

    @Test
    void post(){
        Contact contact = new Contact();
        restTemplate.postForObject(url, contact, Contact.class);
        Mockito.verify(client).post(contact);
    }
}