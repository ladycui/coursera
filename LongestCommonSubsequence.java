package com.cyn.Coursera;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public int[][] maxLen;

    public int getMaxLen(int i, int j){
        if(i < 0 || j < 0)
            return 0;
        else return maxLen[i][j];
    }
/*
* 人人为我
* */
    public int computeMaxLen(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        maxLen = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(chars1[i] == chars2[j])
                    maxLen[i][j] = getMaxLen(i - 1, j - 1) + 1;
                else{
                    maxLen[i][j] = Math.max(getMaxLen(i - 1, j), getMaxLen(i, j - 1));
                }
            }
        }


        return getMaxLen(len1 - 1, len2 - 1);
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            LongestCommonSubsequence obj = new LongestCommonSubsequence();


            System.out.println(obj.computeMaxLen(s1, s2));
    }
}
