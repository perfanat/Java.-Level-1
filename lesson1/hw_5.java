package lesson1;

public class hw_5 {
    public static void main(String[] args) {
        System.out.println(Calc(-5));
    }
    static String Calc (int a){
        String result = a>=0?"положительное":"отрицательное";
        return result;
    }
}
