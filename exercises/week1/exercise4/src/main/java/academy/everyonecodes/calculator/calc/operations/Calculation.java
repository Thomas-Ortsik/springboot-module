package academy.everyonecodes.calculator.calc.operations;

import academy.everyonecodes.calculator.calc.Expression;

public abstract class Calculation {
    private final String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(String symbol) {
        return this.symbol.equals(symbol);
    }

    public abstract double calculate(Expression expression);


}
