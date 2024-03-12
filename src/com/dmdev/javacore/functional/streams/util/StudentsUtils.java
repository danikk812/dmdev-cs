package com.dmdev.javacore.functional.streams.util;

import com.dmdev.javacore.functional.streams.entity.CourseInfo;
import com.dmdev.javacore.functional.streams.entity.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class StudentsUtils {

    private StudentsUtils() {
    }

    public static Map<Integer, List<Student>> groupStudentsByCourse(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCourse));
    }

    public static Map<Integer, Double> getAverageForMoreThenThreeGrades(Map<Integer, List<Student>> studentsByCourse) {
        return studentsByCourse.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> calculateAverageGrade(entry.getValue())
                ));
    }

    private static double calculateAverageGrade(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .flatMap(student -> student.getGrades().stream())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static Map<Integer, List<Student>> getSortedByNameAndSurnameStudents(Map<Integer, List<Student>> studentsByCourse) {
        return studentsByCourse.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> sortStudentsByNameAndSurname(entry.getValue())
                ));
    }

    private static List<Student> sortStudentsByNameAndSurname(List<Student> students) {
        return students.stream()
                .map(student -> new Student(student.getFirstName(), student.getLastName()))
                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .collect(Collectors.toList());

    }

    public static Map<Integer, CourseInfo> getSortedStudentsAndAverageGrades(Map<Integer, List<Student>> studentsByCourse) {
        return studentsByCourse.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new CourseInfo(sortStudentsByNameAndSurname(entry.getValue()),
                                calculateAverageGrade(entry.getValue()))
                ));
    }
}
