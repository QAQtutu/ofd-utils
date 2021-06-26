package com.qaqtutu.ofdutils.doublelayer.utils;

import com.qaqtutu.ofdutils.doublelayer.model.PageVo;
import com.qaqtutu.ofdutils.doublelayer.model.Word;
import org.ofdrw.layout.OFDDoc;
import org.ofdrw.layout.VirtualPage;
import org.ofdrw.layout.element.Img;
import org.ofdrw.layout.element.Paragraph;
import org.ofdrw.layout.element.Position;
import org.ofdrw.layout.element.Span;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * @description: 双层OFD生成工具
 * @author: qaqtutu
 * @create: 2021/06/26 14:25
 * TODO  添加行对象 根据字体位置做合并，推算位置和间距
 */
public class DoubleLayerUtil {

    public static void toOfd(List<PageVo> pageVoList, Path outFile) {
        try (OFDDoc ofdDoc = new OFDDoc(outFile)) {

            for (PageVo pageVo : pageVoList) {
                double pageWidth = pageVo.getWidth();
                double pageHeight = pageVo.getHeight();


                VirtualPage vPage = new VirtualPage(pageWidth, pageHeight);

                /** 第一层图片 */
                Img img = new Img(pageWidth, pageHeight, pageVo.getPath());
                img.setPosition(Position.Absolute).setX(0d).setY(0d);
                vPage.add(img);

                /** 第二层文字 */

                for (Word word : pageVo.getWords()) {
                    Paragraph p = new Paragraph();
                    p.setOpacity(0d);

                    double fontSize = word.getW();
                    double centerX = 0.0 + word.getX() + word.getW() / 2;
                    double centerY = 0.0 + word.getY() + word.getH() / 2;

                    p.setPosition(Position.Absolute)
                            .setHeight((double) word.getH() * 2)
                            .setWidth((double) word.getW() * 2)
                            .setX(centerX - fontSize / 2).setY(centerY - fontSize / 2);
                    Span span = new Span(String.valueOf(word.getWord()));
                    span.setFontSize(fontSize);
                    p.add(span);
                    vPage.add(p);
                }
                ofdDoc.addVPage(vPage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}