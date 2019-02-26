package lesson1;

// задание 1
public class hw {
    public static void main(String[] args) {

        // задание 2
        // целые числа
        byte a = 127;
        short b = 1000;
        int c = 50000;
        long d = 10000000L;

        // дробные числа
        float e = 1.5f;
        double f = 2.5;

        // символы
        char g = 'g';

        // булевы значения
        boolean boo = true;

        // задание 3
        Ex3(1,2,3,4);

        // задание 4
        Ex4(9,5);

        // задание 5
        Ex5(-5);

        // задание 6
        Ex6(5);

        // задание 7
        Ex7("John");

        // задание 8
        Ex8(2000);
        Ex8(2010);
        Ex8(2019);
    }

    static int Ex3 (int a, int b, int c, int d){
        int result = a * (b + (c / d));
        System.out.println("Задание №3: "+a+"*"+"("+b+"+("+c+"/"+d+"))="+result);
        return result;
        }

    static boolean Ex4 (int a, int b){
        boolean result = (a+b)>=10&&(a+b)<=20;
        System.out.println("Задание №4: 10<=("+a+"+"+b+")<=20 = "+result);
        return result;
    }

    static String Ex5 (int a){
        String result = a>=0?"положительное":"отрицательное";
        System.out.println("Задание №5: "+a+" - "+result+" число");
        return result;
    }

    static boolean Ex6 (int a){
        boolean result = a<0;
        System.out.println("Задание №6: "+a+"<0 = "+result);
        return result;
    }

    static void Ex7 (String name){
        System.out.println("Задание №7: Привет, "+name);
    }

    static void Ex8 (int year){
        String result;
        result=(year%4==0&&year%100!=0||year%400==0)?"високосный":"невисокосный";
        System.out.println("Задание №8: "+year+"-й год - это "+result+" год");
    }
}
