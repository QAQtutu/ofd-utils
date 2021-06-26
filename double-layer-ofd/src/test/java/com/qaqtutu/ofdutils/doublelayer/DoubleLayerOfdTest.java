package com.qaqtutu.ofdutils.doublelayer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qaqtutu.ofdutils.doublelayer.model.PageVo;
import com.qaqtutu.ofdutils.doublelayer.model.Word;
import com.qaqtutu.ofdutils.doublelayer.utils.DoubleLayerUtil;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qaqtutu
 * @create: 2021/06/26 12:55
 */
public class DoubleLayerOfdTest {

    @Test
    public void test() throws IOException {

        Path imgPath = Paths.get("src/test/resources", "ofd.png");


        String json = FileUtils.readFileToString(new File("src/test/resources/ocr.json"), "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject result = jsonObject.getJSONObject("result");
        JSONArray pageCoords = result.getJSONArray("coords");
        JSONArray lines = result.getJSONArray("lines");

        int pageWidth = getWidth(pageCoords);
        int pageHeight = getHeight(pageCoords);

        PageVo pageVo = new PageVo(imgPath, pageWidth, pageHeight);

        BufferedImage image = new BufferedImage(pageWidth, pageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();


        BufferedImage bg = ImageIO.read(imgPath.toFile());
        graphics.drawImage(bg, 0, 0, pageWidth, pageHeight, null);
        graphics.setColor(Color.RED);

        for (int i = 0; i < lines.size(); i++) {
            JSONArray words = lines.getJSONObject(i).getJSONArray("chars");
            for (int j = 0; j < words.size(); j++) {
                JSONObject word = words.getJSONObject(j);
                JSONArray wordCoords = word.getJSONArray("coords");
                int x = wordCoords.getInteger(0);
                int y = wordCoords.getInteger(1);
                int w = getWidth(wordCoords);
                int h = getHeight(wordCoords);

                graphics.drawRect(x, y, w, h);
                pageVo.getWords().add(new Word(word.getString("code").charAt(0), x, y, w, h));
            }
        }

        Path path = Paths.get("target/双层OFD.ofd");

        List<PageVo> pages = new ArrayList<>();
        pages.add(pageVo);

        DoubleLayerUtil.toOfd(pages, path);

        ImageIO.write(image, "PNG", new File("target/OCR对照.png"));
    }

    /**
     * 获取包围框宽度
     */
    private static Integer getWidth(JSONArray coords) {
        return coords.getInteger(4) - coords.getInteger(0);
    }

    /**
     * 获取包围框高度
     */
    private static Integer getHeight(JSONArray coords) {
        return coords.getInteger(5) - coords.getInteger(1);
    }

}