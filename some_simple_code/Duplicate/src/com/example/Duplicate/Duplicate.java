package com.example.Duplicate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        File file = new File("Q4a.txt"); // NOTE: find from ./Duplicate
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        // convert string to int array
        String arrayString = scanner.next();
        String[] arrayStringCleaned = arrayString.replace("{", "").replace("}", "").split(",");

        int[] array = new int[arrayStringCleaned.length];
        for (int i = 0; i < arrayStringCleaned.length; i++){
            array[i] = Integer.valueOf(arrayStringCleaned[i]);
        }

        System.out.print("The duplicated numbers are: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.print(array[i] + " ");
                }
            }
        }
    }
}
