package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
        GuessWord();
    }

    public static void GuessWord (){
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[rnd.nextInt(words.length)];
        System.out.println("Угадайти слово из списка:\n"+ Arrays.toString(words));
        StringBuffer help = new StringBuffer ("###############");
        do {
            String ans = scn.nextLine();
            int minLength;
            if (word.length()<ans.length()){minLength=word.length();}else minLength=ans.length();
            for (int i = 0; i < minLength; i++) {
                if(word.charAt(i)==ans.charAt(i)){
                    help.setCharAt(i,word.charAt(i));
                }
            }
            if(ans.equals(word)){
            System.out.println("Вы угадали!");break;
            } else {
            System.out.println("Вы неугадали. Попробуйте ещё раз.(Подсказка: "+help+")");
            } }
        while (true);
    }
}
