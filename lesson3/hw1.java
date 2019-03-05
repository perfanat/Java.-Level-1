package lesson3;

import java.util.Random;
import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        do {
            guessNum ();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            Scanner scn2 = new Scanner(System.in);
            int rep;
            do {
                rep = scn2.nextInt();
                if(rep!=0&&rep!=1){
                    System.out.println("Введено недопустимое число! Попробуйте ещё раз! 1 – да / 0 – нет");}
            }while (rep!=0&&rep!=1);
            if(rep!=1)break;
        } while (true);
    }

    private static void guessNum (){
        Random rnd = new Random();
        Scanner scn1 = new Scanner(System.in);
        System.out.println("Угадайте число от 0 до 9: ");

        int num = rnd.nextInt(10);
        int ans;
        boolean rightAns = false;
        for(int i = 0; i<3; i++){
            do {
                ans = scn1.nextInt();
                if(ans<0||ans>9){
                    System.out.println("Введено недопустимое число! Попробуйте ещё раз! Осталось попыток - "+(3-i));}
            }while (ans<0||ans>9);
            if(ans==num){
                System.out.println("Вы угадали!");
                rightAns = true;
                break;
            } else if (ans>num){
                if (i==2){
                    System.out.println("Вы не угадали. Попыток больше нет!");
                } else System.out.println("Загаданное число меньше! Осталось попыток - "+(2-i));
            } else {
                if (i==2){
                    System.out.println("Вы не угадали. Попыток больше нет!");
                } else System.out.println("Загаданное число больше! Осталось попыток - "+(2-i));
            }
        }
        if (!rightAns) {
            System.out.println("Вы проиграли! (загаданное число - "+num+")");
        }
    }
}
