package academy.everyonecodes.amazinghelloworld.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmazingHelloWorldTest {

    @Autowired
    AmazingHelloWorld helloWorld;

    @Test
    void get() {
        String expected = "Hello World";
        String result = helloWorld.get();
    }
}