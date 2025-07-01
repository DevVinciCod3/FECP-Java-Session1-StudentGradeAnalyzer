package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int student_count = s.nextInt();
        s.nextLine(); // Clear newline

        String[] student_names = new String[student_count];
        int[] student_scores = new int[student_count];
        char[] student_grades = new char[student_count];

        for (int i = 0; i < student_count; i++) {

            System.out.printf("Enter name of student %d: ", i + 1);
            student_names[i] = s.nextLine();

            System.out.printf("Enter score for %s: ", student_names[i]);
            student_scores[i] = s.nextInt();
            s.nextLine(); // Clear newline

            while (student_scores[i] < 0 || student_scores[i] > 100) {
                System.out.print("Invalid score. Enter a value between 0 and 100: ");
                student_scores[i] = s.nextInt();
                s.nextLine(); // Clear newline
            }

            if (student_scores[i] >= 90) {
                student_grades[i] = 'A';
            } else if (student_scores[i] >= 80) {
                student_grades[i] = 'B';
            } else if (student_scores[i] >= 70) {
                student_grades[i] = 'C';
            } else if (student_scores[i] >= 60) {
                student_grades[i] = 'D';
            } else {
                student_grades[i] = 'F';
            }

            System.out.printf("%s got grade: %c%n", student_names[i], student_grades[i]);
        }

        System.out.println("----- Class Summary -----");

        // Calculate sum and average
        int sum = 0;
        for (int score : student_scores) {
            sum += score;
        }

        double average = (double) sum / student_scores.length;
        System.out.printf("Average Score: %.2f%n", average);

        // Count grade distribution
        int a_count = 0, b_count = 0, c_count = 0, d_count = 0, f_count = 0;
        for (char grade : student_grades) {
            switch (grade) {
                case 'A' -> a_count++;
                case 'B' -> b_count++;
                case 'C' -> c_count++;
                case 'D' -> d_count++;
                case 'F' -> f_count++;
            }
        }
        System.out.printf("A:%d B:%d C:%d D:%d F:%d%n", a_count, b_count, c_count, d_count, f_count);

        // Find top student
        int max = student_scores[0];
        int maxIndex = 0;

        for (int i = 1; i < student_scores.length; i++) {
            if (student_scores[i] > max) {
                max = student_scores[i];
                maxIndex = i;
            }
        }
        System.out.printf("Top Student(s): %s (%d)%n", student_names[maxIndex], max);
    }
}
