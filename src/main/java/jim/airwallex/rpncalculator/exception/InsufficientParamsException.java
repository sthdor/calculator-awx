package jim.airwallex.rpncalculator.exception;

public class InsufficientParamsException extends CalculatorException {
    private String opStr;
    
    public InsufficientParamsException(String opStr) {
        this.opStr = opStr;
    }

    public String getOpStr() {
        return opStr;
    }

}
