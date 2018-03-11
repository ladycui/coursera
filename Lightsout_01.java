package com.cyn.Coursera;

import java.util.Scanner;

public class Lightsout_01 {
    public  int[][] puzzle = new int[6][8];
    public  int[][] press = new int[6][8];

    boolean guess(){
        //确定第一行灯的操作后，逐行判断第2～5行灯的操作
        for(int r = 1; r < 5; r++){
           for(int c = 1; c < 7; c++){
               press[r+1][c] = (puzzle[r][c] + press[r][c] +
               press[r-1][c] + press[r][c-1] + press[r][c+1]) % 2;
           }
        }
        //判断第五行灯是否熄灭
        for(int c = 1; c < 7; c++){
            if( (press[5][c-1] + press[5][c] + press[5][c+1] +
            press[4][c] + puzzle[5][c]) % 2 != 0)
                return false;
        }
        return true;
    }

    public void enumerate(){
        int c;
        while(!guess()){
            press[1][1]++;
            //模仿二进制进位，实现枚举（第一行各种情况 2^6)
            c = 1;
            while(press[1][c] > 1){
                press[1][c] =0;
                c++;
                press[1][c]++;
            }
        }
    }

    public static void main(String[] args){
        Lightsout_01 obj = new Lightsout_01();
        Scanner scanner = new Scanner(System.in);
        for(int r = 1; r< 6; r++){
            for(int c = 1; c < 7; c++){
                obj.puzzle[r][c] = scanner.nextInt();
            }
        }
        obj.enumerate();
        for(int r = 1; r < 6; r++) {
            for (int c = 1; c < 7; c++)
                System.out.print(obj.press[r][c]);
            System.out.println();
        }
    }
}
