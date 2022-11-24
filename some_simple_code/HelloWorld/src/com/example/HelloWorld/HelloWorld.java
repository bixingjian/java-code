package com.example.HelloWorld;

public class HelloWorld {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*   ");
            }
            System.out.println(); // the first way to change line.
        }

        System.out.println("My Hello World");

        for (int i = 5; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*   ");
            }
            System.out.print("\n"); // the second way to change line.
        }
    }
}
