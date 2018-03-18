package com.cyn.Coursera;

import java.util.*;

/*
* this is a pracitce demo of Graph
* here is the question: 认老乡题目描述

大学的同学来自全国各地，对于远离家乡步入陌生大学校园的大一新生来说，碰到老乡是多么激动的一件事，于是大家都热衷于问身边的同学是否与自己同乡，
来自新疆的小赛尤其热衷。但是大家都不告诉小赛他们来自哪里，只是说与谁同乡，从所给的信息中，你能告诉小赛有多少人确定是她的同乡吗？

*http://exercise.acmcoder.com/online/online_judge_ques?ques_id=1683&konwledgeId=135
*
* I use BFS to solve it, however it's much easier if using array which animates changing colors, while I just practise the usage of graph
* I hope you don't mind
* */
public class GraphPractice {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        while (n * m != 0) {
            int[][] array = new int[n + 1][n + 1];
            for(int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                array[a][b] = 1;
                array[b][a] = 1;
            }
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            int[] visited = new int[n + 1];
            queue.add(1);
            while(!queue.isEmpty()){
                int v = queue.poll();
                visited[v] = 1;
                for(int i = 1; i < array.length; i++){
                    if(visited[i] == 0 & array[v][i] == 1){
                        queue.add(i);
                        set.add(i);
                    }
                }
            }

            System.out.println(set.size());

        }

    }


}
