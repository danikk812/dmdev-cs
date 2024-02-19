package com.dmdev.javacore.oop.encapsulation.atm.util;

import java.util.Scanner;

public final class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);

        while (!sc.hasNextInt()) {
            System.out.println(prompt);
            sc.next();
        }

        return sc.nextInt();
    }


}
