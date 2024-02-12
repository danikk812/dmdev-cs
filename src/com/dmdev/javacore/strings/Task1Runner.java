package com.dmdev.javacore.strings;

import com.dmdev.javacore.strings.util.ConsoleReader;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 */
public class Task1Runner {

    public static void main(String[] args) {

        String input = ConsoleReader.readString("Input a string: ");
        System.out.println(modifyString(input));

    }


    private static String modifyString(String str) {
        return removeConsecutiveDuplicates(removeSpaces(str)).toUpperCase();
    }

    private static String removeConsecutiveDuplicates(String str) {
        StringBuilder res = new StringBuilder();
        char prev = '\0';

        for (char c : str.toCharArray()) {
            if (Character.toLowerCase(c) != Character.toLowerCase(prev)) {
                res.append(c);
                prev = c;
            }
        }

        return res.toString();
    }

    private static String removeSpaces(String str) {
        return str.replaceAll("\\s", "");
    }
}
