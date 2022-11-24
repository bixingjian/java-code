package Collection;

import java.util.HashSet;

class Employee { // protected?
    public String name;
    public String age;

    public int hashCode() {
        return name.hashCode() ^ age.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Employee employeeObj = (Employee) obj;
        return (this.name.equals(employeeObj.name)) && (this.age.equals(employeeObj.age));

    }

    public Employee(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
    }
}

public class HashSetDemo2 {
    public static void main(String[] args) {
        HashSet<Employee> employeeNamesTwitter = new HashSet<>();
        employeeNamesTwitter.add(new Employee("Joe", "18"));
        employeeNamesTwitter.add(new Employee("Alice", "20"));
        employeeNamesTwitter.add(new Employee("Smith", "24"));
        System.out.println("Twitter's employees" + employeeNamesTwitter);

    }
}
