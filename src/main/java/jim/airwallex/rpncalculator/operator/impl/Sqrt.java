package jim.airwallex.rpncalculator.operator.impl;

import java.util.Stack;

import jim.airwallex.rpncalculator.exception.InsufficientParamsException;
import jim.airwallex.rpncalculator.operator.Operator;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class Sqrt implements Operator {

    @Override
    public CalculatorFrame process(CalculatorFrame currentFrame) {
        CalculatorFrame nextFrame = new CalculatorFrame();
        nextFrame.setData((Stack<Double>) currentFrame.data().clone());
        if(nextFrame.data().size()<1) {
            throw new InsufficientParamsException("sqrt");
        }
        double p1 = (Double)nextFrame.data().pop();
        nextFrame.data().push(Double.valueOf(Math.sqrt(p1)));
        nextFrame.setPrevious(currentFrame);
        return nextFrame;
    }

}
