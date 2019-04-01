package com.cyn.coursera;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Cui Yanna on 2019/3/7
 *
 * review comparator related content, goto https://howtodoinjava.com/java/collections/java-comparator/
 *
 */

public class BothersomeFrog {
    private static Plant[] plants = new Plant[500];




    public static void main(String[] args) {


    }

    public void comparator(){
        Plant a = new Plant(1, 7);
        Plant b = new Plant(2, 7);
        Plant c = new Plant(1, 5);
        Plant d = new Plant(2, 7);
        plants[0] = a;
        plants[1] = b;
        plants[2] = c;
        plants[3] = d;
//        Collections.sort(Arrays.asList(plants), new ComparatorOfPlant());
        Collections.sort(Arrays.asList(plants), Comparator.comparing(Plant::getX)
                .thenComparing(Plant::getY));
    }

}



class Plant {
    int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Plant(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return x == plant.x &&
                y == plant.y;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class ComparatorOfPlant implements Comparator<Plant> {
    @Override
    public int compare(Plant o1, Plant o2) {
        return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
    }
}