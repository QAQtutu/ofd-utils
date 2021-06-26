package com.qaqtutu.ofdutils.doublelayer.model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 页信息
 * @author: qaqtutu
 * @create: 2021/06/26 12:45
 */
public class PageVo {

    public PageVo(Path path, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
    }

    private Path path;

    private int width;

    private int height;

    private List<Word> words = new ArrayList<>();

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}