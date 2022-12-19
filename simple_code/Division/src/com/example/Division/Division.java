package com.example.Division;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter two integers for operation");

            try {
                int dividend = scanner.nextInt();
                int divisor = scanner.nextInt();

                int result = dividend / divisor;
                int remainder = dividend % divisor;

                System.out.println(result);
                System.out.println(remainder);

            } catch (Exception e) {
                System.out.println("Divisor cannot be zero!");
                System.exit(0);
            }

        }
    }
}
