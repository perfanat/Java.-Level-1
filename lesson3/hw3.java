package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Calc();
    }

    public static void Calc(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите операцию с аргументами через пробел:");
        String[]line = scn.nextLine().split(" ");
        System.out.println(Arrays.toString(line));
        int res=0;
        for (int i = 1; i < line.length-1; i+=2) {
            if (i==1){
                switch (line[i]){
                    case "+": res = Integer.parseInt(line[i-1])+Integer.parseInt(line[i+1]);break;
                    case "*": res = Integer.parseInt(line[i-1])*Integer.parseInt(line[i+1]);break;
                    case "/": res = Integer.parseInt(line[i-1])/Integer.parseInt(line[i+1]);break;
                    case "-": res = Integer.parseInt(line[i-1])-Integer.parseInt(line[i+1]);break;
                }
            }
          if (i!=1){
                switch (line[i]){
                    case "+": res += Integer.parseInt(line[i+1]);break;
                    case "*": res *= Integer.parseInt(line[i+1]);break;
                    case "/": res /= Integer.parseInt(line[i+1]);break;
                    case "-": res -= Integer.parseInt(line[i+1]);break;
                }
            }
        }

        System.out.println(res);
    }
}
