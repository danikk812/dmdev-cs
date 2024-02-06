package com.dmdev.cs.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class Task1 {

    public static void main(String[] args) {

        int[] originalNumbers = {6, 10, -12, 16, 24, -27, 0, -111, 45};
        int[] resultNumbers = multiplyElementsByLength(removeNegativeElements(originalNumbers));

        System.out.printf("%s -> %s%n", Arrays.toString(originalNumbers), Arrays.toString(resultNumbers));

    }

    private static int[] removeNegativeElements(int[] numbers) {
        int countPositiveValues = 0;

        for (int number : numbers) {
            if (isPositive(number)) {
                countPositiveValues++;
            }
        }

        int[] positiveNumbers = new int[countPositiveValues];
        int currentNumber = 0;

        for (int number : numbers) {
            if (isPositive(number)) {
                positiveNumbers[currentNumber++] = number;
            }
        }

        return positiveNumbers;
    }

    private static int[] multiplyElementsByLength(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= numbers.length;
        }

        return numbers;
    }

    private static boolean isPositive(int number) {
        return (number >= 0);
    }

}
