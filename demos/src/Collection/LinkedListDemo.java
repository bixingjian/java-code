package Collection;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> employeeNamesTwitter = new LinkedList<>();
        employeeNamesTwitter.add("Joe");
        employeeNamesTwitter.add("Alice");
        employeeNamesTwitter.add("Smith");
        System.out.println("Twitter's employees" + employeeNamesTwitter);

        String employeeNo2 = employeeNamesTwitter.get(2);
        System.out.println("Twitter's employee No2:" + employeeNo2);

        employeeNamesTwitter.remove("Joe");
        System.out.println("Twitter's employees" +  employeeNamesTwitter);
    }
}
