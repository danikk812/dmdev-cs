package com.dmdev.cs.loops;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        printReverseNumberResult(readLong("Enter a whole number: "));
    }

    private static void printReverseNumberResult(long number) {
        System.out.printf("%d -> %d%n", number, reverseNumber(number));
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

    private static long reverseNumber(long number) {
        long reversedNumber = 0;

        int length = (int) (Math.log10(Math.abs(number)) + 1);
        int digitsCapacity = length - 1;

        for (long i = Math.abs(number); i > 0; i /= 10) {
            int digit = (int) (i % 10);
            reversedNumber += (long) (digit * Math.pow(10, digitsCapacity--));
        }

        return (number >= 0) ? reversedNumber : reversedNumber * (-1);
    }
}
