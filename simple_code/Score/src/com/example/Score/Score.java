package com.example.Score;

import java.util.Random;

public class Score {
    public static void main(String[] args) {
        int passedStudentNumber = 0;
        int upperbound = 101;
        Random scoreGenerator = new Random();

        for (int i = 0; i < 100; i++) {
            int score = scoreGenerator.nextInt(upperbound);
            System.out.printf("The score of student %d is %d \n", i, score);
            if (score >= 60) {
                passedStudentNumber += 1;
            }
        }

        System.out.println(passedStudentNumber + " students pass the exam.");
    }
}
