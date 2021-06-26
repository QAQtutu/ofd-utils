package com.qaqtutu.ofdutils.doublelayer.model;

/**
 * @description: 字
 * @author: qaqtutu
 * @create: 2021/06/26 12:46
 */
public class Word {
    private char word;
    private int x;
    private int y;
    private int w;
    private int h;

    public Word(char word, int x, int y, int w, int h) {
        this.word = word;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public char getWord() {
        return word;
    }

    public void setWord(char word) {
        this.word = word;
    }

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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}