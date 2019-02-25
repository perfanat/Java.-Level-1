package lesson1;

public class hw_4 {
    public static void main(String[] args) {
        System.out.println(Calc(9,5));
    }
    static boolean Calc (int a, int b){
        boolean result = (a+b)>=10&&(a+b)<=20;
        return result;
    }
}
