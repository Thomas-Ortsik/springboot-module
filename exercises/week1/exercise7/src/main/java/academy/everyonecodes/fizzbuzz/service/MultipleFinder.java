package academy.everyonecodes.fizzbuzz.service;

public class MultipleFinder {
    private int multiple;

    public MultipleFinder(int multiple) {
        this.multiple = multiple;
    }

    public boolean isMultiple(int number){
        return number % multiple == 0;
    }
}
