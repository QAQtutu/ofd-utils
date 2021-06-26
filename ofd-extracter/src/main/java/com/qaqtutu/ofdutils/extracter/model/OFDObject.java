package com.qaqtutu.ofdutils.extracter.model;

import org.ujmp.core.Matrix;

/**
 * @description:
 * @author: qaqtutu
 * @create: 2021/06/26 17:54
 */
public abstract class OFDObject {

    /*
     * 对象外接矩形
     * */
    private Rectangle boundary;

    /*
     * 变换矩阵  相对于全局空间
     * */
    private Matrix matrix;

    /*
     * 所在页码
     * */
    private int pageNum;

}