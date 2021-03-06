package jim.airwallex.rpncalculator.operator.impl;

import java.util.Stack;

import jim.airwallex.rpncalculator.exception.InsufficientParamsException;
import jim.airwallex.rpncalculator.operator.Operator;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class Plus implements Operator {

    @Override
    public CalculatorFrame process(CalculatorFrame currentFrame) {
        CalculatorFrame nextFrame = new CalculatorFrame();
        nextFrame.setData((Stack<Double>) currentFrame.data().clone());
        if(nextFrame.data().size()<2) {
            throw new InsufficientParamsException("+");
        }
        double p1 = (Double)nextFrame.data().pop();
        double p2 = (Double)nextFrame.data().pop();
        nextFrame.data().push(Double.valueOf(p1+p2));
        nextFrame.setPrevious(currentFrame);
        return nextFrame;
    }

}
