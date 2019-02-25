package lesson1;

public class hw_3 {
    public static void main(String[] args) {
        System.out.println(Calc(1,2,3,4));
    }
    static int Calc (int a, int b, int c, int d){
        int result = a * (b + (c / d));
        return result;
    }
}
