public class Main {
    public void writeValue(int a, byte b){
        System.out.println("byte");
    }
    public void writeValue(int a, short b){
        System.out.println("Int");
    }
    public void writeValue(int a, double b){
        System.out.println("double");
    }
    public static void main(String[] args) {
        new Main().writeValue(2, 5);




    }
}
