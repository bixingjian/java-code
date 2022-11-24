package Collection;

import java.util.HashMap;

public class HashMapDemo
{
	public static void main(String[] args)
	{
		// First create a hashmap with an initial size of 10 and
		// the default load factor
		HashMap<String, Integer> employeeNamesTwitter = new HashMap<>();

		// Add several employees objects to the map using
		// their name as the key
		employeeNamesTwitter.put("Joe", 20);
		employeeNamesTwitter.put("Alice", 40);
		employeeNamesTwitter.put("Smith", 30);
		employeeNamesTwitter.put("Joe", 30);

		System.out.print("Twitter employees: " + employeeNamesTwitter);


	}
}
