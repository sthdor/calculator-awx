package jim.airwallex.rpncalculator.controller;

import java.io.Console;
import java.util.Queue;

import jim.airwallex.rpncalculator.constant.CalculatorConstants;
import jim.airwallex.rpncalculator.sandbox.CalculatorFrame;
import jim.airwallex.rpncalculator.service.CalculatorService;

public class CalculatorController {

    public static void handle() {
        Console console = System.console();
        String opstr = null;
        CalculatorFrame current = CalculatorService.getEmptyFrame();
        while(!(opstr=console.readLine()).equalsIgnoreCase(CalculatorConstants.SHELL_CMD_EXIT)) {
            Queue<String> operations = CalculatorService.parseOperations(opstr);
            try {
                CalculatorFrame st = CalculatorService.calculate(current, operations);
                current = st;
            } catch(Exception e) {
                System.out.println("Error occurs during calculation: " + e.getMessage());
            } 
            System.out.println(CalculatorConstants.SHELL_PREFIX_STACK + CalculatorService.getData(current));
        }
    }
    
}
