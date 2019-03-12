package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XO {

    // параметры игры
    private static int SIZE = 3;
    private static int winSize = 4;
    private static char [][] field = new char[SIZE][SIZE];
    private static char PlayerDot = 'X';
    private static char PkDot = 'O';
    private static char EmptyDot = '_';
    private static Scanner scn = new Scanner(System.in);
    private static Random rnd = new Random();

    // инициализация поля
    private static void InitField (){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j]=EmptyDot;
            }
        }
    }

    // печать поля
    private static void PrintField (){
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+1+"|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j]+"|");
            }
            System.out.println();
        }
    }

    // ход
    private static void Move (int y, int x, char dot){
        field[y][x]=dot;
    }

    // ход человека
    private static void PlayerMove (){
        int x, y;
        do {
            System.out.println("Ваш ход:");
            y = scn.nextInt()-1;
            x = scn.nextInt()-1;
        } while (!isNotRightMove(y,x));
        Move(y,x,PlayerDot);
    }

    // ход компьютера
    private static void PkMove (){
        int x=0, y=0;
        String bl="";
        String rn="";
        boolean res=false;
        int block=0;
        int block2=0;
        int score=0;
        // блокировка левой диагонали
        for (int i = 0; i < SIZE; i++) {
            if (field[i][i]==PlayerDot){
                score++;
            } else if (field[i][i]==EmptyDot){
                block=i;
            }
        }
        if (score>1&&field[block][block]==EmptyDot){
            y=block;
            x=block;
            res=true;
            bl = " (блокирует левую диагональ)";
        } else {score=0;}
        // блокировка правой диагонали
        if (!res){
            for (int i = 0; i < SIZE; i++) {
                if (field[i][SIZE-1-i]==PlayerDot){
                    score++;
                } else if (field[i][SIZE-1-i]==EmptyDot){
                    block=i;
                }
            }
            if (score>1&&field[block][SIZE-1-block]==EmptyDot){
                y=block;
                x=SIZE-1-block;
                res=true;
                bl = " (блокирует правую диагональ)";
            }
        }
        // блокировка горизонтали
        for (int i = 0; i < SIZE; i++) {
            score=0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j]==PlayerDot){
                    score++;
                } else {
                    block=i;
                    block2=j;
                }
            }
            if (score>1&&field[block][block2]==EmptyDot){
                break;
            }
        }
        if (score>1&&field[block][block2]==EmptyDot){
            y=block;
            x=block2;
            res=true;
            bl = " (блокирует горизонталь)";
        }
        // блокировка вертикаль
        for (int i = 0; i < SIZE; i++) {
            score=0;
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i]==PlayerDot){
                    score++;
                } else {
                    block=j;
                    block2=i;
                }
            }
            if (score>1&&field[block][block2]==EmptyDot){
                break;
            }
        }
        if (score>1&&field[block][block2]==EmptyDot){
            y=block;
            x=block2;
            res=true;
            bl = " (блокирует вертикаль)";
        }

        if (!res){
            do {
                y = rnd.nextInt(SIZE);
                x = rnd.nextInt(SIZE);
                rn=" (случайный ход)";
            } while (!isNotRightMove(y,x));
        }
        Move(y,x,PkDot);
        System.out.println("Ход компьютера: "+(y+1)+" "+(x+1)+bl+rn);
    }

    // проверка возможности хода
    private static boolean isNotRightMove (int y, int x){
        return (y>=0||y<SIZE||x>=0||x<SIZE)&&field[y][x]==EmptyDot;
    }

    // проверка заполненности поля
    private static boolean isFieldFull (){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j]==EmptyDot){
                    return false;
                }
            }
        }
        return true;
    }

    // проверка выигрыша
    private static boolean checkWin (char dot){
        boolean res;
        if (SIZE<5){
            res = (winDiag(dot)||winLines(dot));
        } else {
            res=check4(dot);
        }
        return res;
    }

    // проверка выигрыши из 4-к клеток
    private static boolean check4 (char dot){
        return check4Ver(dot)||check4Hor(dot)||check4DiagLeft(dot)||check4DiagRight(dot);
    }

    // проверка выигрыша из 4-к клеток по вертикали
    private static boolean check4Ver (char dot){
        boolean res = false;
        for (int i = 0; i < SIZE-winSize+1; i++) {
            for (int j = 0; j < SIZE; j++) {
                res=true;
                for (int k = 0; k < winSize; k++) {
                    res&=field[i+k][j]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // проверка выигрыши из 4-к клеток по горизонтали
    private static boolean check4Hor (char dot){
        boolean res = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE-winSize+1; j++) {
                res=true;
                for (int k = 0; k < winSize; k++) {
                    res&=field[i][j+k]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // проверка выигрыши из 4-к клеток по левой диагонали
    private static boolean check4DiagLeft (char dot){
        boolean res = false;
        for (int i = 0; i < SIZE-winSize+1; i++) {
            for (int j = 0; j < SIZE-winSize+1; j++) {
                res=true;
                for (int k = 0; k < winSize; k++) {
                    res&=field[i+k][j+k]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // проверка выигрыши из 4-к клеток по правой диагонали
    private static boolean check4DiagRight (char dot){
        boolean res = false;
        for (int i = winSize-1; i < SIZE; i++) {
            for (int j = 0; j < SIZE-winSize+1; j++) {
                res=true;
                for (int k = 0; k < winSize; k++) {
                    res&=field[i-k][j+k]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // проверка выигрыша по диагоналям
    private static boolean winDiag (char dot){
        boolean res = true;
        for (int i = 0; i < SIZE; i++) {
            res&=field[i][i]==dot;
        }
        if (res){
            return true;
        } else {
            res=true;
        }
        for (int i = 0; i < SIZE; i++) {
            res&=field[i][SIZE-i-1]==dot;
        }
        return res;
    }

    // проверка выигрыша по линиям
    private static boolean winLines (char dot){
        boolean res = true;
        for (int i = 0; i < SIZE; i++) {
            res=true;
            for (int j = 0; j < SIZE; j++) {
                res&=field[i][j]==dot;
            }
            if (res){
                break;
            }
        }
        if (res){
            return true;
        } else {
            res=true;
        }
        for (int i = 0; i < SIZE; i++) {
            res=true;
            for (int j = 0; j < SIZE; j++) {
                res&=field[j][i]==dot;
            }
            if (res){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        InitField ();
        PrintField();
        while (true){
            PlayerMove();
            PrintField();
            if (checkWin(PlayerDot)){
                System.out.println("Вы выиграли!");
                break;
            }
            if (isFieldFull()){
                System.out.println("Ничья!");
                break;
            }
            PkMove();
            PrintField();
            if (checkWin(PkDot)){
                System.out.println("Компьютер выиграл!");
                break;
            }
            if (isFieldFull()){
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
