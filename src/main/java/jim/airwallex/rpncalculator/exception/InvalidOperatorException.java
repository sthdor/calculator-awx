package jim.airwallex.rpncalculator.exception;

public class InvalidOperatorException extends CalculatorException {
    private String invalidOpStr;
    
    public InvalidOperatorException(String invalidOpStr) {
        this.invalidOpStr = invalidOpStr;
    }

    public String getInvalidOpStr() {
        return invalidOpStr;
    }
    
}
