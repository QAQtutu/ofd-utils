package com.qaqtutu.ofdutils.extracter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qaqtutu
 * @create: 2021/06/26 17:55
 */
public class OFDTextObject extends OFDObject {


    /*
     * Word 内所有的字
     * */
    List<Word> wordList = new ArrayList<>();

    @Override
    public String toString() {
        return "OFDTextObject{" +
                "wordList=" + wordList +
                '}';
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
}