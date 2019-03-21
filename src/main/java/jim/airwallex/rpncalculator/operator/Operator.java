package jim.airwallex.rpncalculator.operator;

import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public interface Operator {

    CalculatorFrame process(CalculatorFrame currentFrame);

}
