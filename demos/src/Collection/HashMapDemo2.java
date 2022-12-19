package Collection;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo2
{
    public static void main(String[] args)
    {
        // First create a hashmap with an initial size of 10 and
        // the default load factor
        HashMap<Employee, Integer> employeeNamesTwitter = new HashMap<>(); // Employee defined in HashSetDemo2

        // Add several employees objects to the map using
        // their name as the key
        employeeNamesTwitter.put(new Employee("jeo", "18"), 20);
        employeeNamesTwitter.put(new Employee("Alice", "18"), 40);
        employeeNamesTwitter.put(new Employee("Smith", "24"), 20);
        employeeNamesTwitter.put(new Employee("jeo", "18"), 30);


        System.out.print("Twitter employees: " + employeeNamesTwitter);


    }
}
