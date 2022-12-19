package Collection;

import java.util.TreeMap;

public class TreeMapDemo
{
    public static void main(String[] args)
    {
        // First create a hashmap with an initial size of 10 and
        // the default load factor
        TreeMap<String, Integer> employeeNamesTwitter = new TreeMap<>(); // keys will be in order

        // Add several employees objects to the map using
        // their name as the key
        employeeNamesTwitter.put("Joe", 20);
        employeeNamesTwitter.put("Alice", 40);
        employeeNamesTwitter.put("Smith", 30);
        employeeNamesTwitter.put("Joe", 30);

        System.out.print("Twitter employees: " + employeeNamesTwitter);


    }
}
