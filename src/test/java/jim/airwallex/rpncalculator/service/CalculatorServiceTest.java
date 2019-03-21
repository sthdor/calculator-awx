package jim.airwallex.rpncalculator.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class CalculatorServiceTest {
    
    @Test
    public void testCalculate() {
        Queue<String> operators = new LinkedList<String>();
        String[] ops = {"5", "3", "*"};
        operators.addAll(Arrays.asList(ops));
        CalculatorFrame frame = CalculatorService.calculate(CalculatorService.getEmptyFrame(), operators);
        assertTrue(frame.data().pop().equals(Double.valueOf(15.0)));
    }

}
