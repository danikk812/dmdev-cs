package com.dmdev.javacore.functional.streams.entity;

import java.util.List;
import java.util.Objects;

public class CourseInfo {

    private List<Student> students;
    private Double averageGrade;

    public CourseInfo(List<Student> students, Double averageGrade) {
        this.students = students;
        this.averageGrade = averageGrade;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseInfo that = (CourseInfo) o;
        return Objects.equals(students, that.students) && Objects.equals(averageGrade, that.averageGrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, averageGrade);
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "students=" + students +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
