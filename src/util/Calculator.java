package util;

import java.math.BigDecimal;

public class Calculator {

    public static String cal(String exp) {
        exp = exp.replace(" ", "");
        String[] arr = exp.split("[-+*/]");

        String operandLeft = arr[0];
        String operandRight = arr[1];
        char operator = exp.charAt(operandLeft.length());

        switch (operator) {
            case '+':
                return new BigDecimal(operandLeft).add(new BigDecimal(operandRight)).toString();
            case '-':
                return new BigDecimal(operandLeft).subtract(new BigDecimal(operandRight)).toString();
            case '*':
                return new BigDecimal(operandLeft).multiply(new BigDecimal(operandRight)).toString();
            case '/':
                if ("0".equals(operandRight)) {
                    return "Divided by zero is unaccepted!";
                } else {
                    return new BigDecimal(operandLeft).divide(new BigDecimal(operandRight), 4).toString();
                }
        }

        return null;
    }

}
