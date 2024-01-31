package com.dmdev.cs.functions;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * <p>
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class Task3 {

    public static void main(String[] args) {

        int a1 = 4;
        int b1 = 9;

        int a2 = 5;
        int b2 = 6;

        compareAreas(squareRightTriangle(a1, b1), squareRightTriangle(a2, b2));

    }

    private static double squareRightTriangle(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Error: the triangle sides must be positive values");
        }

        return 0.5 * (a * b);
    }

    private static void compareAreas(double area1, double area2) {
        if (area1 > area2) {
            System.out.printf("First triangle area (%f) is greater than the second (%f)%n", area1, area2);
        } else if (area1 < area2) {
            System.out.printf("First triangle area (%f) is less than the second (%f)%n", area1, area2);
        } else {
            System.out.printf("The areas of two triangles (%f) are equal%n", area1);
        }
    }


}
