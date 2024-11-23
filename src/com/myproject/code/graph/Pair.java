package com.myproject.code.graph;

public class Pair {
    String str;
    int first;
    int second;
    int time;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Pair(String str, int second) {
        this.str = str;
        this.second = second;
    }

    public Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
