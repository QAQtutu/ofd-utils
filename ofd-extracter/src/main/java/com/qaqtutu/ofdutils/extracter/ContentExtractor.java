package com.qaqtutu.ofdutils.extracter;

import com.qaqtutu.ofdutils.extracter.model.OFDObject;
import com.qaqtutu.ofdutils.extracter.model.OFDPage;
import com.qaqtutu.ofdutils.extracter.model.OFDTextObject;
import com.qaqtutu.ofdutils.extracter.model.Word;
import org.ofdrw.core.basicStructure.pageObj.layer.CT_Layer;
import org.ofdrw.core.basicStructure.pageObj.layer.PageBlockType;
import org.ofdrw.core.basicStructure.pageObj.layer.block.CT_PageBlock;
import org.ofdrw.core.basicStructure.pageObj.layer.block.ImageObject;
import org.ofdrw.core.basicStructure.pageObj.layer.block.TextObject;
import org.ofdrw.core.text.TextCode;
import org.ofdrw.reader.OFDReader;
import org.ofdrw.reader.PageInfo;
import org.ofdrw.reader.ResourceManage;
import org.ujmp.core.Matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qaqtutu
 * @create: 2021/06/26 16:55
 */
public class ContentExtractor {

    public static List<OFDPage> extract(OFDReader reader) {

        List<OFDPage> pages = new ArrayList<>();

        ResourceManage resMgt = reader.getResMgt();

        int pageNum = reader.getNumberOfPages();
        for (int i = 1; i <= pageNum; i++) {
            PageInfo page = reader.getPageInfo(i);

            OFDPage ofdPage = new OFDPage();

            List<CT_Layer> ctLayers = page.getAllLayer();
            for (CT_Layer layer : ctLayers) {
                CT_PageBlock pageBlock = layer;
                readPageBlock(ofdPage, pageBlock, resMgt, null);
            }

            pages.add(ofdPage);

        }
        return pages;
    }

    private static void readPageBlock(OFDPage page, CT_PageBlock pageBlock, ResourceManage resMgt, Matrix matrix) {
        for (PageBlockType object : pageBlock.getPageBlocks()) {
            if (object instanceof TextObject) {
                TextObject textObject = (TextObject) object;
                readTextObject(page, textObject, matrix);
            } else if (object instanceof ImageObject) {
                ImageObject imageObject = (ImageObject) object;
                try {
                    resMgt.getImageByteArray(imageObject.getResourceID().getRefId().getId().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(imageObject.getResourceID());
            }
        }
    }

    private static void readTextObject(OFDPage page, TextObject textObject, Matrix matrix) {
        OFDTextObject ofdTextObject = new OFDTextObject();

        for (TextCode textCode : textObject.getTextCodes()) {
            for (char c : textCode.getContent().toCharArray()) {
                Word word = new Word();
                word.setWord(c);

                ofdTextObject.getWordList().add(word);
            }
        }

        page.getContents().add(ofdTextObject);
    }
}