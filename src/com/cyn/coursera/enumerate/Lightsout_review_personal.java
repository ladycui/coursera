package com.cyn.coursera.enumerate;

/**
 * @Auther: cyn
 * @Date: 2020-02-09 18:51
 * @Description: 0: 灭的； 1： 亮的
 */
public class Lightsout_review_personal {

    static int row = 5;
    static int col = 6;

    static int[][] states = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };
    static int[][] operations = new int[row + 2][col + 2];


    public static void main(String[] args) {
        int[] operate1st = new int[col];
        int index;
        while (!operate(operate1st)) {
            operate1st[0]++;
            index = 0;
            while (operate1st[index] > 1 && index < col - 1) {
                operate1st[index++] = 0;
                operate1st[index]++;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print(operations[i][j] + "\t");
            }
            System.out.println();
        }

    }


    /**
     * 输入第一行的操作序列，推算第六行状态
     *
     * @param
     * @return
     */
    static boolean operate(int[] operate1st) {
        for (int j = 0; j < col; j++) {
            operations[1][j + 1] = operate1st[j];
        }


        for (int i = 1; i < row; i++)
            for (int j = 1; j <= col; j++)
                operations[i + 1][j] = (operations[i][j] + operations[i - 1][j] + operations[i][j - 1]
                        + operations[i][j + 1] + states[i][j]) % 2;
        for (int j = 1; j <= col; j++) {
            if ((states[row][j] + operations[row][j - 1] + operations[row][j] + operations[row][j + 1] + operations[row - 1][j]) % 2 == 1) {
                return false;
            }
        }
        return true;
    }

}
