package jim.airwallex.rpncalculator.operator.impl;

import jim.airwallex.rpncalculator.operator.Operator;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class Undo implements Operator {

    @Override
    public CalculatorFrame process(CalculatorFrame currentFrame) {
        return currentFrame.previous();
    }

}
