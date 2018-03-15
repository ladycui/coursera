package com.cyn.Coursera;

import java.util.Scanner;

public class DPMathTriangle {

    public int n;
    public int[][] array;

    public DPMathTriangle(int n, int[][] array){
        this.n = n;
        this.array = array;
    }

    public int max(int a, int b){
        return a > b ? a : b;
    }

    public int sum(int n, int[][] array){
        int[][] sums = new int[n][n];
        for(int i = 0; i < n; i++)
            sums[n-1][i] = array[n-1][i];
        for(int i = n-2; i >=0; i--){
            for(int j = 0; j <= i; j++){
                sums[i][j] = max(sums[i+1][j], sums[i+1][j+1]) + array[i][j];
            }
        }
        return sums[0][0];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++)
                array[i][j] = scanner.nextInt();
        }
        DPMathTriangle obj = new DPMathTriangle(n, array);
        System.out.println(obj.sum(n, array));

    }

}
