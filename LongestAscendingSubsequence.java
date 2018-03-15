package com.cyn.Coursera;

import java.util.Scanner;

public class LongestAscendingSubsequence {
    public int n;
    public int[] array;
    public int[] maxLen;

    public LongestAscendingSubsequence(int n){
        this.n = n;
        this.array = new int[n];
        this.maxLen = new int[n];
        for(int i = 0; i < n; i++){
            this.maxLen[i] = 1;
        }
    }

    /*人人为我*/
    public void compute(){
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i])
                    maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
            }
        }
    }

    /*我为人人*/
    public void anotherCompute(){
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j ++)
                if(array[i] < array[j])
                    maxLen[j] = Math.max(maxLen[j],maxLen[i] + 1);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        LongestAscendingSubsequence obj = new LongestAscendingSubsequence(n);

        for(int i = 0; i < n; i++)
            obj.array[i] = scanner.nextInt();
        obj.compute();
//        obj.anotherCompute();
        System.out.println(obj.maxLen[n - 1]);

    }
}
