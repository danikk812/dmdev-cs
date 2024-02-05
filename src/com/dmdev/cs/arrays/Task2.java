package com.dmdev.cs.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {

    public static void main(String[] args) {
        char[] originalSymbols = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};

        printResultReport(originalSymbols);
    }

    private static void printResultReport(char[] originalSymbols) {
        int[] resultNumbers = convertCharsToNumbers(originalSymbols);
        double averageMean = averageMean(resultNumbers);

        System.out.printf("Symbols array converted to numbers array: %s -> %s%n", Arrays.toString(originalSymbols), Arrays.toString(resultNumbers));
        System.out.printf("Average mean of elements: %s -> %f%n", Arrays.toString(resultNumbers), averageMean);
        System.out.printf("Elements greater average mean (>%f): %s -> %s", averageMean, Arrays.toString(resultNumbers), Arrays.toString(getElementsGreaterAverageMean(resultNumbers, averageMean)));
    }

    private static int[] convertCharsToNumbers(char[] symbols) {
        int[] numbers = new int[symbols.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = symbols[i];
        }
        return numbers;
    }

    private static int[] getElementsGreaterAverageMean(int numbers[], double averageMean) {
        int count = 0;

        for (int number : numbers) {
            if (number > averageMean) {
                count++;
            }
        }

        int[] newNumbers = new int[count];
        int currentNumber = 0;

        for (int number : numbers) {
            if (number > averageMean) {
                newNumbers[currentNumber++] = number;
            }
        }

        return newNumbers;
    }

    private static double averageMean(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.length;
    }
}
