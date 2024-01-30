package com.dmdev.cs.functions;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class Task1 {

    public static void main(String[] args) {

        int minutes = -1;
        defineQuarterOfHour(minutes);

    }

    private static void defineQuarterOfHour(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            int quarter = (minutes == 0) ? 1 : (int) Math.ceil(minutes / 15.0);
            System.out.println("Minute " + minutes + " is in the " + quarter + " quarter of an hour");
        } else {
            System.out.println("Invalid minutes value " + minutes +  " (0 <= minutes <= 59)");
        }
    }


}
