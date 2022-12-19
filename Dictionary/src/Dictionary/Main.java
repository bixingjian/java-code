package Dictionary;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> a =  new HashSet<>();
        HashSet<Integer> b =  new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        b.add(2);
        b.add(3);
        b.add(4);
        a.retainAll(b);
        System.out.println(a);
    }

}
