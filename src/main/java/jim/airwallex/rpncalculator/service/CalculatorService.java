package jim.airwallex.rpncalculator.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import jim.airwallex.rpncalculator.constant.CalculatorConstants;
import jim.airwallex.rpncalculator.exception.InsufficientParamsException;
import jim.airwallex.rpncalculator.exception.InvalidOperatorException;
import jim.airwallex.rpncalculator.operator.Operator;
import jim.airwallex.rpncalculator.operator.impl.Clear;
import jim.airwallex.rpncalculator.operator.impl.Divide;
import jim.airwallex.rpncalculator.operator.impl.Minus;
import jim.airwallex.rpncalculator.operator.impl.Multi;
import jim.airwallex.rpncalculator.operator.impl.Number;
import jim.airwallex.rpncalculator.operator.impl.Plus;
import jim.airwallex.rpncalculator.operator.impl.Sqrt;
import jim.airwallex.rpncalculator.operator.impl.Undo;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;

public class CalculatorService {
    
    private static final Operator plus = new Plus();
    private static final Operator minus = new Minus();
    private static final Operator multi = new Multi();
    private static final Operator divide = new Divide();
    private static final Operator sqrt = new Sqrt();
    private static final Operator undo = new Undo();
    private static final Operator clear = new Clear();
    
    private static final CalculatorFrame emptyFrame = new CalculatorFrame();
    static {
        Stack<Double> data = new Stack<Double>();
        emptyFrame.setData(data);
        emptyFrame.setPrevious(null);
    }

    public static Operator getOperator(String opStr) {
        if(opStr.equals("+")) {
            return plus;
        } else if(opStr.equals("-")) {
            return minus;
        } else if(opStr.equals("*")) {
            return multi;
        } else if(opStr.equals("/")) {
            return divide;
        } else if(opStr.equals("sqrt")) {
            return sqrt;
        } else if(opStr.equals("undo")) {
            return undo;
        } else if(opStr.equals("clear")) {
            return clear;
        } else if(StringUtils.isNumeric(opStr)) {
            Number numOp = new Number();
            numOp.setParam(Double.valueOf(opStr));
            return numOp;
        } else {
            throw new InvalidOperatorException(opStr);
        }
    }
    
    public static CalculatorFrame getEmptyFrame() {
        return emptyFrame;
    }
    
    public static CalculatorFrame calculate(CalculatorFrame current, Queue<String> operations) {
        CalculatorFrame res = (current==null)?getEmptyFrame():current;
        
        if(operations!=null) {
            //System.out.println(CalculatorConstants.TAG_DEBUG + operations);
            int idx = 1;
            while(operations.peek()!=null) {
                CalculatorFrame curr = res;
                try {
                    Operator op = getOperator(operations.poll());
                    res = op.process(curr);
                    idx++;
                } catch(InvalidOperatorException ioe) {
                    System.out.println(String.format("operator %s (index: %d): invalid operator", 
                            ioe.getInvalidOpStr(), idx));
                    break;
                } catch(InsufficientParamsException ipe) {
                    System.out.println(String.format("operator %s (index: %d): insufficient parameters", 
                            ipe.getOpStr(), idx));
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static Queue<String> parseOperations(String opss) {
        Queue<String> operations = new LinkedList<String>();
        if(StringUtils.isNotBlank(opss)) {
            String[] opArray = StringUtils.split(opss, CalculatorConstants.WHITESPACE_ONE);
            operations.addAll(Arrays.asList(opArray));
        }
        return operations;
    }
    
    public static String getData(CalculatorFrame frame) {
        StringBuffer outStr = new StringBuffer("");
        if(null!=frame && frame.data()!=null) {
            for(Double d : (Stack<Double>)frame.data()) {
                if(d%1 == 0) {
                    outStr.append(String.valueOf(d.intValue())).append(CalculatorConstants.WHITESPACE_ONE);
                } else {
                    outStr.append(String.valueOf(d.doubleValue())).append(CalculatorConstants.WHITESPACE_ONE);
                }
            }
        }
        return outStr.toString();
    }
}
