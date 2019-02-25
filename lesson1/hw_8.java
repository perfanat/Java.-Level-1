package lesson1;

public class hw_8 {
    public static void main(String[] args) {
        Year(2017);
        Year(2000);
        Year(2010);
    }
    static void Year (int year){
        String result;
        result=(year%4==0&&year%100!=0||year%400==0)?"високосный":"невисокосный";
        System.out.println(result);
    }
}
