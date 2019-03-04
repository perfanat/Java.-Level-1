package lesson2;

import java.util.Arrays;

public class hw {
    public static void main(String[] args) {

        // задание 1
        int arr1[]={1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Задание №1: "+Arrays.toString(arr1));

        // задание 2
        int arr2 [] = new int[8];
        for (int i = 0; i<arr2.length; i++){
            arr2[i]=i*3;
            }
        System.out.println("Задание №2: "+Arrays.toString(arr2));

        // задание 3
        int arr3[]={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i<arr3.length; i++){
            if(arr3[i]<6)arr3[i]*=2;
        }
        System.out.println("Задание №3: "+Arrays.toString(arr3));

        // задание 4
        int arr4[][]=new int[5][5];
        System.out.println("Задание №4:");
        for(int i = 0; i<arr4.length;i++){
            for(int j=0; j<arr4.length;j++){
                if(i==j||i==arr4.length-j-1)arr4[i][j]=1;
                    else arr4[i][j]=0;
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println();
        }

        // задание 5
        int arr5 []={2,3,4,9,8,7,5};
        int min = arr5[0];
        int max = arr5[0];
        for(int i = 1;i<arr5.length;i++){
            if(arr5[i]<min)min=arr5[i];
            if(arr5[i]>max)max=arr5[i];
        }
        System.out.println("Задание №5: мин.="+min+", макс.="+max);

        // задание 6
        System.out.println("Задание №6:");
        int arrEx61[]={2, 2, 2, 1, 2, 2, 10, 1};
        int arrEx62[]={1, 1, 1, 2, 1};
        System.out.println("→ "+checkBalance(arrEx61));
        System.out.println("→ "+checkBalance(arrEx62));

        // задание 7
        System.out.print("Задание №7: ");
        int arrEx7[]={1,2,3,4,5,6};
        arrMove(arrEx7, -10);

        // задание 8 (доп. 1)
        int arr8[]=new int[50];
        int count1 = 0;
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){arr8[count1]=i;count1++;}
        }
        System.out.println("Задание №8: "+Arrays.toString(arr8));

        // задание 9 (доп. 2)
        System.out.println("Задание №9:");
        int arr9[]=new int [15];
        int count2 = 0;
        for (int i = 0; i<15; i++){
            arr9[i]=(int)(Math.random()*10);
            if(arr9[i]%2==0)count2+=1;
        }
        System.out.println(Arrays.toString(arr9));
        System.out.println("Чётных элементов в массиве - "+count2);

        // задание 10 (доп. 3)
        System.out.println("Задание №10:");
        int arr101[]=new int [5];
        int arr102[]=new int [5];
        int sum1=0;
        int sum2=0;
        for (int i = 0; i<5; i++){
            arr101[i]=(int)(Math.random()*6);
            arr102[i]=(int)(Math.random()*6);
            sum1+=arr101[i];
            sum2+=arr102[i];
        }
        System.out.println(Arrays.toString(arr101));
        System.out.println(Arrays.toString(arr102));
        if(sum1/5==sum2/5){
            System.out.println("Cредние арифметические двух массивов равны");
        } else if (sum1/5>sum2/5){System.out.println("Cреднее арифметическое 1-го массива больше, чем 2-го");}
        else {System.out.println("Cреднее арифметическое 2-го массива больше, чем 1-го");}
    }

    public static boolean checkBalance (int arr6[]){
        int sum1=0;
        int sum2=0;
        boolean result = false;
        for(int i = 0;i<arr6.length;i++){
            sum1+=arr6[i];
        }
        for(int i = 0;i<arr6.length;i++){
            sum2+=arr6[i];
            if(sum2==sum1-sum2){
                result=true;
                System.out.print(arr6[i]+"||");
            }
            else System.out.print(arr6[i]+" ");
        }
        return result;
    }

    public static void arrMove (int arr7[], int n){
        int arr7Move[]= new int[arr7.length];
        for (int i = 0; i < arr7.length; i++) {
            if(n<0){
                if(i+n%arr7.length<0){arr7Move[i]=arr7[i+n%arr7.length+arr7.length];}
                else {arr7Move[i]=arr7[i+n%arr7.length];}
            }
            else{if(i+n%arr7.length>=arr7.length){arr7Move[i]=arr7[i+n%arr7.length-arr7.length];}
            else {arr7Move[i]=arr7[i+n%arr7.length];}}
        }
        System.out.println(Arrays.toString(arr7Move));
    }
}

