package jim.airwallex.rpncalculator.operator.impl;

import java.util.Stack;

import jim.airwallex.rpncalculator.operator.Operator;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class Clear implements Operator {

    @Override
    public CalculatorFrame process(CalculatorFrame currentFrame) {
        CalculatorFrame nextFrame = new CalculatorFrame();
        nextFrame.setData((Stack<Double>) currentFrame.data().clone());
        nextFrame.data().clear();
        nextFrame.setPrevious(currentFrame);
        return nextFrame;
    }

}
