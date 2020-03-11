package academy.everyonecodes.fizzbuzz.service;

import java.util.List;

public class FizzBuzz {
    private final MultipleFinder multipleOfThree;
    private final MultipleFinder multipleOfFive;


    public FizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        this.multipleOfThree = multipleOfThree;
        this.multipleOfFive = multipleOfFive;
    }

    public String apply(int number) {
        String fizzbuzz = "";
        if (multipleOfThree.isMultiple(number)) {
            fizzbuzz += "Fizz";
        }
        if (multipleOfFive.isMultiple(number)) {
            fizzbuzz += "Buzz";
        }
        if (fizzbuzz.equals("")) {
            fizzbuzz = String.valueOf(number);
        }
        return fizzbuzz;
    }

}
