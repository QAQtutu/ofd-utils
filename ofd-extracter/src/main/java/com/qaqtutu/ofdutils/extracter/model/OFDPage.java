package com.qaqtutu.ofdutils.extracter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qaqtutu
 * @create: 2021/06/26 18:09
 */
public class OFDPage {

    /**
     * 宽
     */
    private float width = 0;

    /**
     * 高
     */
    private float height = 0;


    /**
     * 内容
     */
    private List<OFDObject> contents = new ArrayList<>();


    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public List<OFDObject> getContents() {
        return contents;
    }

    public void setContents(List<OFDObject> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "OFDPage{" +
                "width=" + width +
                ", height=" + height +
                ", contents=" + contents +
                '}';
    }
}