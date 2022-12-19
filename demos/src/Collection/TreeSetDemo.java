package Collection;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> employeeNamesTwitter = new TreeSet<>(); // [sorted] based on String value
        employeeNamesTwitter.add("Joe");
        employeeNamesTwitter.add("Alice");
        employeeNamesTwitter.add("Smith");
        System.out.println("Twitter's employees" + employeeNamesTwitter);

    }
}
