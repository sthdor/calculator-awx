package jim.airwallex.rpncalculator.operator.impl;

import java.util.Stack;

import jim.airwallex.rpncalculator.operator.Operator;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class Number implements Operator {
    
    private double param;

    public double getParam() {
        return param;
    }

    public void setParam(double param) {
        this.param = param;
    }

    @Override
    public CalculatorFrame process(CalculatorFrame currentFrame) {
        CalculatorFrame nextFrame = new CalculatorFrame();
        nextFrame.setData((Stack<Double>) currentFrame.data().clone());
        nextFrame.data().push(Double.valueOf(param));
        nextFrame.setPrevious(currentFrame);
        return nextFrame;
    }

}
