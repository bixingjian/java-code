package com.example.MoreDuplicate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MoreDuplicate {
    public static void main(String[] args) {
        File file = new File("Q4b.txt"); // NOTE: find from ./Duplicate
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

        int len = arrayStringCleaned.length; // the length of our array

        int[] array = new int[len];
        for (int i = 0; i < len; i++){
            array[i] = Integer.valueOf(arrayStringCleaned[i]);
        }

//        HashMap<Integer, Integer> duplicatedDict = new HashMap<>(); // I'm not sure whether this code has time complexity of O(n) so I'll choose another method.
//        System.out.println("The duplicated elements are: ");
//        for (int i = 0; i < array.length; i++) {
//            if (!duplicatedDict.containsKey(array[i])) {
//                duplicatedDict.put(array[i], 1);
//            } else {
//                int newValue = duplicatedDict.get(array[i]) + 1;
//                duplicatedDict.replace(array[i], newValue);
//            }
//        }
//
//        for (int key : duplicatedDict.keySet()) {
//            int duplicatedTimes = duplicatedDict.get(key);
//            if (duplicatedTimes > 1) {
//                System.out.println(key + " appears " + duplicatedTimes + " times ");
//            }
//        }

        int[] duplicateTimes = new int[len];

        for (int i = 0; i < len; i++) {
            duplicateTimes[array[i]] += 1;
        }

        for (int i = 0; i < len; i++) {
            if (duplicateTimes[i] > 1) {
                System.out.println(i + " appears " + duplicateTimes[i] + " times");
            }
        }


    }
}
