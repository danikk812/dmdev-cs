package com.dmdev.javacore.functional.streams;

import com.dmdev.javacore.functional.streams.entity.CourseInfo;
import com.dmdev.javacore.functional.streams.entity.Student;
import com.dmdev.javacore.functional.streams.util.StudentsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentsApplication {

    public static void main(String[] args) {

        List<Student> students = getStudents();

        Map<Integer, List<Student>> studentsByCourse = StudentsUtils.groupStudentsByCourse(students);

        Map<Integer, Double> averageGradesByCourse = StudentsUtils.getAverageForMoreThenThreeGrades(studentsByCourse);
        Map<Integer, List<Student>> sortedByNameAndSurnameByCourse = StudentsUtils.getSortedByNameAndSurnameStudents(studentsByCourse);
        Map<Integer, CourseInfo> sortedStudentsAndAverageGradesByCourse = StudentsUtils.getSortedStudentsAndAverageGrades(studentsByCourse);

        System.out.println("Average Grades by Course:");
        System.out.println(averageGradesByCourse);

        System.out.println("\nSorted Students Names and Surnames by Course:");
        System.out.println(sortedByNameAndSurnameByCourse);

        System.out.println("\nSorted Students and Average Grades by Course:");
        System.out.println(sortedStudentsAndAverageGradesByCourse);


    }

    private static List<Student> getStudents() {
        Student ivan = new Student("Ivan", "Ivanov", 1, List.of(4, 4, 5, 8, 8, 9));
        Student alexandr = new Student("Alexandr", "Beliy", 1, List.of(5, 5, 6, 7, 9, 9));
        Student anastasia = new Student("Anastasia", "Nikitenko", 2, List.of(5, 5, 9, 8, 4));
        Student nikita = new Student("Nikita", "Anikievich", 2, List.of(4, 5, 2, 8, 6));
        Student anna = new Student("Anna", "Dolova", 3, List.of(4, 4, 4, 4, 4));
        Student danila = new Student("Danila", "Paramonov", 3, List.of(5, 2, 9, 9, 9));
        List<Student> students = List.of(ivan, alexandr, anastasia, nikita, anna, danila);
        return students;
    }
}
