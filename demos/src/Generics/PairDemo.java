package Generics;

public class PairDemo {
    public static void main(String[] args) {
        Pair<String> pair1 = new Pair<String>("joe", "eecs40");
        Pair<String> pair2 = new Pair<String>("joe", "eecs40");
        System.out.println(pair1.equals(pair2));
    }
}
