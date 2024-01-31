package com.dmdev.cs.functions;

/**
 * Даны 3 переменные:
 * <p>
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * <p>
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * <p>
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */
public class Task2 {

    private final static char ADDITION = '+';
    private final static char SUBTRACTION = '-';
    private final static char MULTIPLICATION = '*';
    private final static char DIVISION = '/';
    private final static char MODULUS = '%';

    public static void main(String[] args) {

        double num1 = 25.5;
        double num2 = 10;
        char operation = MODULUS;

        printOperationResult(num1, num2, operation);

        num1 = 10.0;
        num2 = 0.0;
        operation = DIVISION;

        printOperationResult(num1, num2, operation);

    }

    private static void printOperationResult(double operand1, double operand2, char operation) {
        String operationOutput = String.format("%f %c %f = %f", operand1, operation, operand2, calculate(operand1, operand2, operation));
        System.out.println(operationOutput);
    }

    private static double calculate(double operand1, double operand2, char operation) {

        return switch (operation) {
            case ADDITION -> sum(operand1, operand2);
            case SUBTRACTION -> subtract(operand1, operand2);
            case MULTIPLICATION -> multiply(operand1, operand2);
            case DIVISION -> divide(operand1, operand2);
            case MODULUS -> modulate(operand1, operand2);
            default ->
                    throw new IllegalArgumentException("Error: invalid operation '" + operation + "'. Supported operations: '+', '-', '*', '/', '%'");
        };
    }

    private static double sum(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private static double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double divide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Error: division by zero");
        }
        return operand1 / operand2;
    }

    private static double modulate(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Error: division by zero");
        }
        return operand1 % operand2;
    }


}
