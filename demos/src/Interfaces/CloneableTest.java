package Interfaces;

class A implements Cloneable { // only one class in a package is acceptable
    int i;
    String s;
    public A(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { // we can realize deep clone (two different addresses) instead of shallow clone (same address)
        return super.clone();
    }
}

public class CloneableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(20, "Joe");
        A b = (A) a.clone();
        System.out.println(b.i);
        System.out.println(b.s);
    }

}
