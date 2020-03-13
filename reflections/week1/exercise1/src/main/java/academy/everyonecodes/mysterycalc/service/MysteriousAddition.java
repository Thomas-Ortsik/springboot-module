package academy.everyonecodes.mysterycalc.service;

public class MysteriousAddition {
    private int number;

    public MysteriousAddition(int number) {
        this.number = number;
    }

    public int apply(int addition){
        return number + addition;
    }
}
