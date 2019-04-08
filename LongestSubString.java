package com.cyn.Coursera;

/**
 * @author Cui Yanna on 2019/4/8
 */

public class LongestSubString {

    private String a;
    private String b;
    private int[][] f;
    private int result;

    public LongestSubString(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        LongestSubString obj = new LongestSubString("abc", "abcdabc");
        System.out.println(obj.function());
    }

    private int function() {
        int lenA = a.length();
        int lenB = b.length();
        f = new int[lenA + 1][lenB + 1];
        for (int i = 0; i <= lenA; i++) {
            f[i][0] = 0;
        }
        for (int i = 0; i <= lenB; i++) {
            f[0][i] = 0;
        }

        for (int i = 0; i < lenA; i++)
            for (int j = 0; j < lenB; j++) {
                if(a.charAt(i) == b.charAt(j))
                    f[i + 1][j + 1] = f[i][j] + 1;
                else
                    f[i + 1][j + 1] = 0;
                result = Math.max(result, f[i + 1][j + 1]);
            }


        return result;
    }
}
