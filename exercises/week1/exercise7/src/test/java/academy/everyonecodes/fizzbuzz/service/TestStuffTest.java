package academy.everyonecodes.fizzbuzz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestStuffTest {
    @Autowired
    TestStuff testStuff;

    TestStuff testStuffWithoutSpring = new TestStuff(new FizzBuzz(new MultipleFinder(3), new MultipleFinder(5)));

    @Test
    void test() {
        testStuff.doStuff();
    }
}