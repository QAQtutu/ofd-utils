package com.qaqtutu.ofdutils.extracter.model;

/**
 * @description: 字
 * @author: qaqtutu
 * @create: 2021/06/26 12:46
 */
public class Word extends OFDObject {
    private char word;

    public char getWord() {
        return word;
    }

    public void setWord(char word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word=" + word +
                '}';
    }
}