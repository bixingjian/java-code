package Collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetIteratorDemo
{
    public static void main(String[] args)
    {
        HashSet<String> employeeNamesTwitter = new HashSet<>();
        employeeNamesTwitter.add("Joe");
        employeeNamesTwitter.add("Alice");
        employeeNamesTwitter.add("Smith");
        employeeNamesTwitter.add("Joe"); // this is a set, only one "Jeo"

        Iterator<String> i = employeeNamesTwitter.iterator(); // cursor is one place ahead at the beginning.
        while(i.hasNext()) {
            System.out.println(i.next());
        }

        i.remove(); // remove the last item where the cursor is at
        i = employeeNamesTwitter.iterator(); // cursor is one place ahead at the beginning.
        while(i.hasNext()) {
            System.out.println(i.next());
        }


    }
}
 

