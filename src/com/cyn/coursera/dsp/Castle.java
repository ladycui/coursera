package com.cyn.coursera.dsp;

import java.util.Scanner;

public class Castle {
    private int[][] input;
    private int[][] color;
    private int roomNum;
    private int maxArea;
    private int roomArea;

    /*
    * 这里数组不会越界，因为只有旁边有空地时（input & 1/2/4/8 == 0）才会下一步dsp*/
    public void dfs(int i, int k) {
        if (color[i][k] > 0)//这个块之前来过
            return;
        roomArea++;
        color[i][k] = roomNum;
        if ((input[i][k] & 1) == 0)
            dfs(i, k - 1);
        if ((input[i][k] & 2) == 0)
            dfs(i - 1, k);
        if ((input[i][k] & 4) == 0)
            dfs(i, k + 1);
        if ((input[i][k] & 8) == 0)
            dfs(i + 1, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        Castle obj = new Castle();
        obj.input = new int[r][c];
        obj.color = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                obj.input[i][j] = scanner.nextInt();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (obj.color[i][j] == 0) {
                    obj.roomNum++;
                    obj.roomArea = 0;
                    obj.dfs(i, j);
                    obj.maxArea = Math.max(obj.maxArea, obj.roomArea);
                }
            }
        }

        System.out.println(obj.roomNum + " " + obj.maxArea);

    }
}
