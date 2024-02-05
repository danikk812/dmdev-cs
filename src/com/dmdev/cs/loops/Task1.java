package com.dmdev.cs.loops;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {

    public static void main(String[] args) {

        printEvenAndOddDigitsReport(readLong("Enter a whole number: "));
    }

    private static void printEvenAndOddDigitsReport(long number) {

        long evenDigitsCount = countEvenDigits(number);
        long oddDigitsCount = countOddDigits(number);
        String evenDigits = stringifyDigits(number, true);
        String oddDigits = stringifyDigits(number, false);

        System.out.printf("The number %d has %d even digits (%s) and %d odd digits (%s)%n", number, evenDigitsCount, evenDigits, oddDigitsCount, oddDigits);
    }

    private static long readLong(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);

        while (!sc.hasNextLong()) {
            System.out.println(prompt);
            sc.next();
        }

        return sc.nextLong();
    }

    private static int countEvenDigits(long number) {
        return countDigits(number, true);
    }

    private static int countOddDigits(long number) {
        return countDigits(number, false);
    }

    private static int countDigits(long number, boolean countEven) {
        int count = 0;

        for (long i = Math.abs(number); i > 0; i /= 10) {
            int digit = (int) i % 10;
            if ((countEven && isEvenDigit(digit)) || (!countEven && !isEvenDigit(digit))) {
                count++;
            }
        }

        return count;
    }

    private static String stringifyDigits(long number, boolean checkEven) {
        StringJoiner joiner = new StringJoiner(",");

        for (long i = Math.abs(number); i > 0; i /= 10) {
            int digit = (int) (i % 10);
            if ((checkEven && isEvenDigit(digit)) || (!checkEven && !isEvenDigit(digit))) {
                joiner.add(String.valueOf(digit));
            }
        }

        return new StringBuilder(joiner.toString()).reverse().toString();
    }

    private static boolean isEvenDigit(int digit) {
        return (digit % 2 == 0);
    }

}
