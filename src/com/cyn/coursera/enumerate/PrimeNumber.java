package com.cyn.coursera.enumerate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: cyn
 * @Date: 2020-02-09 17:21
 * @Description: 枚举：输出小于n的所有素数
 * <p>
 * 枚举过程中要尽可能减少循环次数；
 * 本问题需要考虑的点：1. 素数n是 不能被2～<n的素数（not整数）整除；2. n必为奇数。
 *
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        List<Integer> primeNums = new ArrayList<>();
        primeNums.add(2);
        int cur = 3;
        boolean flag;
        while (cur < n) {
            flag = true;
            for (Integer i : primeNums) {
                if (cur % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeNums.add(cur);
            }
            cur += 2;
        }

        for (Integer i : primeNums) {
            System.out.println(i);
        }
    }

}
