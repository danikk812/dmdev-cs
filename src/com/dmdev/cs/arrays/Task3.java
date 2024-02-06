package com.dmdev.cs.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 */
public class Task3 {

    private final static char POSITIVE = '+';
    private final static char NEGATIVE = '-';
    private final static char ZERO = '0';

    public static void main(String[] args) {

        int[] originalArray = {-4, 0, 1, 9, 0, -18, 3, 0, 22};

        System.out.println(Arrays.deepToString(splitNumbersTo2DArrayBySign(originalArray)));

    }

    private static int[][] splitNumbersTo2DArrayBySign(int[] numbers) {
        return new int[][]{
                populateNumbersBySign(numbers, NEGATIVE),
                populateNumbersBySign(numbers, ZERO),
                populateNumbersBySign(numbers, POSITIVE)
        };

    }

    private static int[] populateNumbersBySign(int[] numbers, char sign) {
        int[] numbersBySign = getNumbersBySign(numbers, sign);
        int currentNumber = 0;

        for (int number : numbers) {
            switch (sign) {
                case POSITIVE:
                    if (number > 0) {
                        numbersBySign[currentNumber++] = number;
                    }
                    break;
                case NEGATIVE:
                    if (number < 0) {
                        numbersBySign[currentNumber++] = number;
                    }
                    break;
                case ZERO:
                    if (number == 0) {
                        numbersBySign[currentNumber++] = number;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Error: invalid number sign symbol");
            }
        }

        return numbersBySign;
    }

    private static int[] getNumbersBySign(int[] numbers, char sign) {
        int count = 0;

        for (int number : numbers) {
            switch (sign) {
                case POSITIVE:
                    if (number > 0) {
                        count++;
                    }
                    break;
                case NEGATIVE:
                    if (number < 0) {
                        count++;
                    }
                    break;
                case ZERO:
                    if (number == 0) {
                        count++;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Error: invalid number sign symbol");
            }
        }

        return new int[count];
    }

}
