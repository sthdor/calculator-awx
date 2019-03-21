package jim.airwallex.rpncalculator;

import jim.airwallex.rpncalculator.controller.CalculatorController;

public class CalculatorMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Airwallex, this is an RPN Calculator implemenation.\n");
        System.out.println("    Usage: type in numbers, operators and 'Enter' to see stack result.");
        System.out.println("        e.g: 5 4 3 + ");
        System.out.println("    Type 'bye' to exit the program.\n");
        CalculatorController.handle();
    }
}
