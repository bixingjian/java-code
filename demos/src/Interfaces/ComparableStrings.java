package Interfaces;

import java.util.ArrayList;
import java.util.Collections;
public class ComparableStrings {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add("bob");
        a.add("alice");
        a.add("joe");
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);
    }
}