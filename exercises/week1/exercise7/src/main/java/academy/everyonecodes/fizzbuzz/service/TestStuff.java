package academy.everyonecodes.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class TestStuff {
    private final FizzBuzz fizzBuzz;

    public TestStuff(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public void doStuff(){
        System.out.println(fizzBuzz.apply(3) + fizzBuzz.apply(15) + fizzBuzz.apply(5));
    }
}
