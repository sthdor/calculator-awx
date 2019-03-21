package jim.airwallex.rpncalculator.sandbox;

import java.util.Stack;

import jim.airwallex.rpncalculator.operator.Operator;

public class CalculatorFrame {
    
    private Stack<Double> data;
    
    private CalculatorFrame previous;

    public Stack<Double> data() {
        return data;
    }

    public CalculatorFrame next(Operator operator) {
        return operator.process(this);
    }

    public CalculatorFrame previous() {
        return previous;
    }

    public void setData(Stack<Double> data) {
        this.data = data;
    }

    public CalculatorFrame getPrevious() {
        return previous;
    }

    public void setPrevious(CalculatorFrame previous) {
        this.previous = previous;
    }


}
