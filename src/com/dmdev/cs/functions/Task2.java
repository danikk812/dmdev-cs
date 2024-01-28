package com.dmdev.cs.functions;

/**
 * Даны 3 переменные:
 *
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 *
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 *
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */
public class Task2 {

    public static void main(String[] args) {

        double num1 = 25.5;
        double num2 = 10;
        char operation = '%';

       printOperationResult(num1, num2, operation);

       num1 = 10.0;
       num2 = 0.0;
       operation = '/';

       printOperationResult(num1, num2, operation);

    }

    public static void printOperationResult(double operand1, double operand2, char operation) {
        String operationOutput = String.format("%f %c %f = %f", operand1, operation, operand2, calculate(operand1,operand2,operation));
        System.out.println(operationOutput);
    }

    public static double calculate(double operand1, double operand2, char operation) {

        if ((operation == '/' || operation == '%') && operand2 == 0) {
            throw new IllegalArgumentException("Error: division by zero");
        }

        return switch (operation) {
        case '+' -> operand1 + operand2;
        case '-' -> operand1 - operand2;
        case '*' -> operand1 * operand2;
        case '/' -> operand1 / operand2;
        case '%' -> operand1 % operand2;
        default -> throw new IllegalArgumentException("Error: invalid operation '" + operation + "'. Supported operations: '+', '-', '*', '/', '%'");
       };
    }


}
