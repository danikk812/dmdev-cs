package com.dmdev.javacore.strings;

import com.dmdev.javacore.strings.util.ConsoleReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2Runner {

    public static void main(String[] args) {

        String input = ConsoleReader.readString("Enter a string containing digits form 0 to 9: ");
        printProblemReport(input);

    }

    private static void printProblemReport(String input) {
        List<Integer> digitsFromString = extractDigitsFromString(input);
        int sum = sumDigits(extractDigitsFromString(input));

        StringJoiner joiner = new StringJoiner("+");
        for (int digit : digitsFromString) {
            joiner.add(String.valueOf(digit));
        }

        String sumOperationInput = joiner.toString();

        System.out.printf("\"%s\" -> %d (%s)", input, sum, sumOperationInput);
    }

    private static List<Integer> extractDigitsFromString(String str) {
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher countDigitsMatcher = digitPattern.matcher(str);

        List<Integer> digitsFromString = new ArrayList<>();

        while (countDigitsMatcher.find()) {
            digitsFromString.add(Integer.parseInt(countDigitsMatcher.group()));
        }

        return digitsFromString;
    }

    private static int sumDigits(List<Integer> digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }
}
