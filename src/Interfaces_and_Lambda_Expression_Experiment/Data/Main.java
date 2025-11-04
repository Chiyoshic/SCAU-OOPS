package Interfaces_and_Lambda_Expression_Experiment.Data;

import java.util.Arrays;

public class Main {

    private static void printStudents(Student[] students, String title) {
        System.out.println(title);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("20190201", "David", "Software Engineering"),
                new Student("20190202", "Edward", "Software Engineering"),
                new Student("20190101", "Zed", "Computer Science"),
                new Student("20190102", "Bob", "Computer Science"),
                new Student("20190103", "Charlie", "Computer Science"),
                new Student("20190301", "Fred", "Data Science"),
        };

        printStudents(students, "原始输出:");


        Arrays.sort(students, (s1, s2) -> s1.getId().compareTo(s2.getId()));
        printStudents(students, "按学号排序后输出:");

        Arrays.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printStudents(students, "按姓名排序后输出:");

        Arrays.sort(students, (s1, s2) -> s2.getMajor().compareTo(s1.getMajor()));
        printStudents(students, "按专业排序后输出:");
    }
}
