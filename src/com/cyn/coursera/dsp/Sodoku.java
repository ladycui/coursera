package com.cyn.coursera.dsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sodoku {
    static int[][] nums = new int[9][9];
    static int[][] mark = new int[9][9];
    static List<int[]> order = new ArrayList<>();

    public static void main(String[] args) {
        intput();
        if (dfs(0))
            print();
    }

    public static boolean dfs(int l) {
        if (l >= order.size())
            return true;

        int i = order.get(l)[0];
        int j = order.get(l)[1];

//        mark[i][j] = 1;
        for (int k = 1; k < 10; k++) {
            if (!isValid(i, j, k)) continue;
            nums[i][j] = k;
            if( dfs(l + 1)) return true;
        }
//        mark[i][j] = 0;
        nums[i][j] = 0;


        return false;
    }

    public static boolean isValid(int i, int j, int k) {
        for (int p = 0; p < 9; p++) {
            if (nums[i][p] == k && p!= j || nums[p][j] == k && p != i) return false;
        }
        int r = i / 3;
        int c = j / 3;
        for (int p = r * 3; p < 3 * (r + 1); p++) {
            for (int q = c * 3; q < 3 * (c + 1); q++)
                if (nums[p][q] == k && p != i && q != j) return false;
        }
        return true;
    }

    /**
     * input:
     * 103000509
     * 002109400
     * 000704000
     * 300502006
     * 060000050
     * 700803004
     * 000401000
     * 009205800
     * 804000107
     * output:
     * 1	4	3	6	2	8	5	7	9
     * 5	7	2	1	3	9	4	6	8
     * 9	8	6	7	5	4	2	3	1
     * 3	9	1	5	4	2	7	8	6
     * 4	6	8	9	1	7	3	5	2
     * 7	2	5	8	6	3	9	1	4
     * 2	3	7	4	8	1	6	9	5
     * 6	1	9	2	7	5	8	4	3
     * 8	5	4	3	9	6	1	2	7
     */
    public static void intput() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 9; j++) {
                nums[i][j] = Integer.valueOf(line.charAt(j) - 48);
                if (nums[i][j] == 0) {
                    int[] location = {i, j};
                    order.add(location);
                } else
                    mark[i][j] = 1;
            }
        }
    }


    public static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
